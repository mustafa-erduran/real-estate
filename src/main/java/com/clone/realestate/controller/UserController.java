package com.clone.realestate.controller;

import com.clone.realestate.dto.request.UserRequest;
import com.clone.realestate.dto.response.UserResponse;
import com.clone.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController()
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findUserByUserId(id),HttpStatus.OK);
    }

   /* @GetMapping("/users/{email}")
    public ResponseEntity<UserResponse> findUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.findUserByEmail(email),HttpStatus.OK);
    }*/

    @PostMapping(value = "/users" )
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users")
    public ResponseEntity<HttpStatus> deleteAllUsers(){
        userService.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id){
        userService.deleteUserByUserId(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
