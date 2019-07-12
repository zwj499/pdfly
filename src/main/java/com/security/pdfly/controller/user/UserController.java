package com.security.pdfly.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.pdfly.bean.ApiBaseResponse;
import com.security.pdfly.controller.base.BaseController;
import com.security.pdfly.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserDetailsService userDetailsService;


//    @GetMapping()
//    public ApiBaseResponse quyeryOne(@RequestParam UserParam param) {
//        return setResponse(userDetailsService.loadUserByUsername(param.getUsername()));
//    }

    @GetMapping
    public ApiBaseResponse findUserByName(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        return setResponse(principal);
    }

}
