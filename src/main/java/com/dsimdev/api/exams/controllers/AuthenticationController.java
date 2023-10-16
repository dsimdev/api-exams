package com.dsimdev.api.exams.controllers;

import com.dsimdev.api.exams.configs.JwtUtils;
import com.dsimdev.api.exams.exceptions.UserNotFoundException;
import com.dsimdev.api.exams.pojos.JwtRequest;
import com.dsimdev.api.exams.pojos.JwtResponse;
import com.dsimdev.api.exams.pojos.User;
import com.dsimdev.api.exams.services.impls.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            this.authenticateUser(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UserNotFoundException e) {
            throw new Exception("USER NOT FOUND" + e.getMessage());
        }

        UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticateUser(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException exception) {
            throw new Exception("USER DISABLED " + exception.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("BAD CREDENTIALS " + e.getMessage());
        }
    }

    @GetMapping("/active-user")
    public User getActiveUser(Principal principal) {
        return (User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
    }
}
