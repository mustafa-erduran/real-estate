package com.clone.realestate.service;

import com.clone.realestate.dto.request.UserRequest;
import com.clone.realestate.dto.response.UserResponse;
import com.clone.realestate.model.User;
import com.clone.realestate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    private User convertRequestToUser(UserRequest request){
        return User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                //.age(request.getAge())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    private UserResponse convertUserToUserResponse(User savedUser){
        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .surname(savedUser.getSurname())
                //.age(savedUser.getAge())
                .email(savedUser.getEmail())
                .build();
    }

    public UserResponse createUser(UserRequest request){
        User savedUser = convertRequestToUser(request);
        userRepository.save(savedUser);
        return convertUserToUserResponse(savedUser);
    }

    public List<UserResponse> getAllUsers() {
        List<UserResponse> userList = new ArrayList<>();

        for (User user : userRepository.findAll()) {
            userList.add(convertUserToUserResponse(user));
        }
        return userList;
    }

    public UserResponse findUserByUserId(Long userId){
        return convertUserToUserResponse(userRepository.findById(userId).get());
    }

   /* public UserResponse findUserByEmail(String email){
        return convertUserToUserResponse(userRepository.findByUserByEmail(email));
    }*/

    public void deleteUserByUserId(Long userId){
        userRepository.deleteById(userId);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }


}
