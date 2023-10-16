package com.dsimdev.api.exams.controllers;

import com.dsimdev.api.exams.pojos.Role;
import com.dsimdev.api.exams.pojos.User;
import com.dsimdev.api.exams.pojos.UserRole;
import com.dsimdev.api.exams.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setPhoto("default.png");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> userRoles = new HashSet<>();

        Role role = new Role();
        role.setRolId(2L);
        role.setRoleName("USER");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoles.add(userRole);

        return userService.createUser(user, userRoles);
    }

    @GetMapping
    public List<User> readUsers() {
        return userService.readUsers();
    }

    @GetMapping("/{username}")
    public User readUser(@PathVariable("username") String username) {
        return userService.readUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

}