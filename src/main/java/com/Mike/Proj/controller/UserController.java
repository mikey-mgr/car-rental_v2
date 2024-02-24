package com.Mike.Proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mike.Proj.dto.ResponseDto;
import com.Mike.Proj.dto.user.SigninDto;
import com.Mike.Proj.dto.user.SigninResponseDto;
import com.Mike.Proj.dto.user.SignupDto;
import com.Mike.Proj.service.UserService;

@RestController
@RequestMapping("/user")
//for configuring access to the backend controller from
//a different server/origin ie. vue app
@CrossOrigin("http://localhost:8500")
public class UserController {

    @Autowired
    UserService userService;

    //signup api
    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto){
        return userService.signUp(signupDto);
    }

    //signin api
    @PostMapping("/signin")
    public SigninResponseDto signin(@RequestBody SigninDto signinDto){
        return userService.signIn(signinDto);
    }
}
