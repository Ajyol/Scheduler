package com.theboys.scheduler.dto;

import com.theboys.scheduler.entity.User;
import lombok.Getter;
import lombok.Setter;

public class UserDto {
    @Getter @Setter
    private int userId;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private User.UserRole role;
    private EmployeeDto employee;

    public enum UserRole {
        ADMIN, MANAGER, EMPLOYEE
    }
}
