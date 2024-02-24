package com.Mike.Proj.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mike.Proj.dto.ResponseDto;
import com.Mike.Proj.dto.user.SigninDto;
import com.Mike.Proj.dto.user.SigninResponseDto;
import com.Mike.Proj.dto.user.SignupDto;
import com.Mike.Proj.exceptions.AuthenticationFailException;
import com.Mike.Proj.exceptions.CustomException;
import com.Mike.Proj.model.AuthenticationToken;
import com.Mike.Proj.model.User;
import com.Mike.Proj.repository.UserRepo;

import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;

    //signup service
    @Transactional
    public ResponseDto signUp(SignupDto signupDto) {
        //check if user exists
        if (Objects.nonNull(userRepo.findByEmail(signupDto.getEmail()))){
            throw new CustomException("User with email is already present");
        }

        //hash password
        String encryptedPassword = signupDto.getPassword();
        
        try {
            encryptedPassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }

        User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), encryptedPassword, "USER");
        userRepo.save(user);

        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveConfirmationToken(authenticationToken);

        ResponseDto responseDto = new ResponseDto("Success", "New User has been created");
        return responseDto;
    }

    //encrypt password
    private String hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hash;
    }

    //signin to app
    public SigninResponseDto signIn(SigninDto signinDto) {
        //check if user exists
        User user = userRepo.findByEmail(signinDto.getEmail());
        if (Objects.isNull(user)){
            throw new AuthenticationFailException("User is not valid");
        }
        //validate password
        try {
            if(!user.getPassword().equals(hashPassword(signinDto.getPassword()))){
                throw new AuthenticationFailException("User is not valid");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
        
        //find token if passwords match
        AuthenticationToken token = authenticationService.getToken(user);

        if (Objects.isNull(token)){
            throw new CustomException("Authentication token not found");
        } else return new SigninResponseDto("Login Success", token.getToken());
    }
}
