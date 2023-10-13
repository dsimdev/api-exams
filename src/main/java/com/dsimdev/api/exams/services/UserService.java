package com.dsimdev.api.exams.services;

import com.dsimdev.api.exams.pojos.User;
import com.dsimdev.api.exams.pojos.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

    public List<User> readUsers();

    public User readUser(String username);

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public void deleteUser(Long userId);

}