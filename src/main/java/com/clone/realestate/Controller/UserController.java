package com.clone.realestate.Controller;

import com.clone.realestate.Dto.Request.UserRequest;
import com.clone.realestate.Dto.Response.UserResponse;
import com.clone.realestate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllAdvert() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id){
        return new ResponseEntity<>(userService.findUserByUserId(id),HttpStatus.OK);
    }

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
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable UUID id){
        userService.deleteUserByUserId(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
