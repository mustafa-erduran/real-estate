package com.clone.realestate.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(nullable = false)
    private UUID id = UUID.randomUUID();
    private String name;
    private String surname;
    private Integer age;
    @Column(unique = true)
    private String email;
    private String password;



}
