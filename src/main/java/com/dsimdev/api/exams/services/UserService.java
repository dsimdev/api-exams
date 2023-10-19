package com.dsimdev.api.exams.services;

import com.dsimdev.api.exams.pojos.User;
import com.dsimdev.api.exams.pojos.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> readUsers();

    User readUser(String username);

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    void deleteUser(Long userId);

    User updateUser(User user);

}