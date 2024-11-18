package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.UserDto;
import com.theboys.scheduler.entity.User;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    UserDto findById(int theId);
    UserDto save(User theUser);
    void deleteById(int theId);
}
