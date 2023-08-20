package com.product.ecommerce.controller;

import com.product.ecommerce.dto.UserRequestDto;
import com.product.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    public final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/noAuth/addUser")
    public String addUser(@RequestBody UserRequestDto userRequestDto){
        userService.addUsers(userRequestDto);
        return "the user has been added";
    }

}
