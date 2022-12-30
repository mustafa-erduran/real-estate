package com.clone.realestate.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;

    public  UUID generateId(){ return UUID.randomUUID(); }


}
