package com.Hackathon.AiHealthManagement.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Hackathon.AiHealthManagement.Models.User;
import com.Hackathon.AiHealthManagement.Services.UserService;
import com.Hackathon.AiHealthManagement.dtos.UserDTO;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService service;
    
    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO user) {
        log.info("Received user data: {}", user);

        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            log.error("Missing fields: {}", user);
            return new ResponseEntity<>("Missing required feilds",HttpStatus.BAD_REQUEST);
        }

        User newUser = service.addNewUser(user.getName(), user.getEmail(), user.getPassword());
        log.info("Created new user: {}", newUser);

        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }
        
    
    
}

   