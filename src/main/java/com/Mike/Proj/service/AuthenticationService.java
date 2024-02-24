package com.Mike.Proj.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mike.Proj.exceptions.AuthenticationFailException;
import com.Mike.Proj.model.AuthenticationToken;
import com.Mike.Proj.model.User;
import com.Mike.Proj.repository.TokenRepository;

@Service
public class AuthenticationService {

    @Autowired
    TokenRepository tokenRepository;

    @SuppressWarnings("null")
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }

    //find user by token
    public User getUser(String token){
       final AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
       if(Objects.isNull(authenticationToken)){
            throw new AuthenticationFailException("Token isn't valid");
       }
       //authentication token is not null
       return authenticationToken.getUser();
    }

    public void authenticate(String token){
        if(Objects.isNull(token)){
            throw new AuthenticationFailException("Token isn't present");
        }
        if(Objects.isNull(getUser(token))){
            throw new AuthenticationFailException("Token isn't valid");
        }
    }
}
