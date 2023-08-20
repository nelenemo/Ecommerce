package com.product.ecommerce.service;

import com.product.ecommerce.dto.UserRequestDto;
import com.product.ecommerce.entity.User;
import com.product.ecommerce.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public ModelMapper mapper;
    @Autowired
    public UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void addUsers(UserRequestDto userRequestDto) {
        userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        User map = mapper.map(userRequestDto, User.class);
        userRepo.save(map);

    }
}
