package com.clone.realestate.Service;

import com.clone.realestate.Dto.Request.UserRequest;
import com.clone.realestate.Dto.Response.UserResponse;
import com.clone.realestate.Model.User;
import com.clone.realestate.Repository.UserRepository;
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
                .age(request.getAge())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    private UserResponse convertUserToUserResponse(User savedUser){
        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .surname(savedUser.getSurname())
                .age(savedUser.getAge())
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

    public UserResponse findUserByUserId(UUID userId){
        return convertUserToUserResponse(userRepository.findById(userId).get());
    }

    public void deleteUserByUserId(UUID userId){
        userRepository.deleteById(userId);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }


}
