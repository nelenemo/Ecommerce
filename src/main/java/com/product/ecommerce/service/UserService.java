package com.product.ecommerce.service;

import com.product.ecommerce.dto.UserRequestDto;
import com.product.ecommerce.entity.User;

import java.util.Optional;

public interface UserService {
    void addUsers(UserRequestDto userRequestDto);

    Optional<User> findUserById(Long userId);
}
