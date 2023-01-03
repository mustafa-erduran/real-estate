package com.clone.realestate.Repository;

import com.clone.realestate.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    //public User findByUserByEmail(String email);
}
