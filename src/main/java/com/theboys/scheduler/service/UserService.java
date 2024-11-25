package com.theboys.scheduler.service;

import com.theboys.scheduler.dao.UserRepository;
import com.theboys.scheduler.dto.UserDto;
import com.theboys.scheduler.entity.User;
import com.theboys.scheduler.exception.UserNotFoundException;
import com.theboys.scheduler.mapper.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    private final EntityDtoMapper entityDtoMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserService(EntityDtoMapper entityDtoMapper, UserRepository userRepository) {
        this.entityDtoMapper = entityDtoMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return entityDtoMapper.mapUserToDtoList(users);
    }

    @Override
    public UserDto findById(int theId) {
        Optional<User> user = userRepository.findById(theId);
        return user.map(entityDtoMapper::mapUserToDto)
                .orElseThrow(() -> new UserNotFoundException("User with Id " + theId + " not found."));
    }

    @Override
    public UserDto save(UserDto theUser) {
        User user = entityDtoMapper.mapUserDtoToEntity(theUser);
        user = userRepository.save(user);
        return entityDtoMapper.mapUserToDto(user);
    }

    @Override
    public void deleteById(int theId) {
        if (!userRepository.existsById(theId));

    }
}
