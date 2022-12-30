package com.clone.realestate.Service;

import com.clone.realestate.Dto.Request.UserRequest;
import com.clone.realestate.Dto.Response.UserResponse;
import com.clone.realestate.Model.User;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {

    private Map<UUID,User> userMap = new HashMap<>();


    private User convertRequestToUser(UserRequest request){
        User user = new User();
        user.setId(user.generateId());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setAge(request.getAge());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
      return user;
    }

    private UserResponse convertUserToUserResponse(User savedUser){
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setSurname(savedUser.getSurname());
        response.setAge(savedUser.getAge());
        response.setEmail(savedUser.getEmail());
        return response;
    }

    public UserResponse createUser(UserRequest request){
        User savedUser = convertRequestToUser(request);
        userMap.put(savedUser.getId(),savedUser);
        return convertUserToUserResponse(savedUser);
    }

    public List<UserResponse> getAllUsers() {
        List<UserResponse> userList = new ArrayList<>();

        for (UUID userId : userMap.keySet()) {
            userList.add(convertUserToUserResponse(userMap.get(userId)));
        }
        return userList;
    }

    public UserResponse findUserByUserId(UUID userId){
        return convertUserToUserResponse(userMap.get(userId));
    }

    public void deleteUserByUserId(UUID userId){
        userMap.remove(userId);
    }

    public void deleteAllUsers(){
        userMap.clear();
    }


}
