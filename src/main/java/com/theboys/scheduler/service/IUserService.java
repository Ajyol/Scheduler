package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    UserDto findById(int theId);
    UserDto save(UserDto theUser);
    void deleteById(int theId);
}
