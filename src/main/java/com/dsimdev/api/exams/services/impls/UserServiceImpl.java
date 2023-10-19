package com.dsimdev.api.exams.services.impls;

import com.dsimdev.api.exams.exceptions.UserFoundException;
import com.dsimdev.api.exams.pojos.User;
import com.dsimdev.api.exams.pojos.UserRole;
import com.dsimdev.api.exams.repos.RoleRepository;
import com.dsimdev.api.exams.repos.UserRepository;
import com.dsimdev.api.exams.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> readUsers() {
        return userRepository.findAll();
    }

    @Override
    public User readUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser != null) {
            throw new UserFoundException("User already exists");
        } else {
            for (UserRole userRole : userRoles) {
                roleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }

        return localUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

}