package com.clone.realestate.Dto.Request;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;

}
