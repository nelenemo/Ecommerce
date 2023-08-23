package com.product.ecommerce.controller;

import com.product.ecommerce.dto.UserRequestDto;
import com.product.ecommerce.entity.User;
import com.product.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/noauth/findUserById/{userId}")
    public Optional<User> findUserById(@PathVariable Long userId){
       return  userService.findUserById(userId);

    }

}
