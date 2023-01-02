package com.clone.realestate.Dto.Response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponse {

    private UUID id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
}
