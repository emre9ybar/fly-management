package com.flyroute.fly.repository;

import com.flyroute.fly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    boolean existsByEmail(String email);
    boolean existsById(Integer id);

   Optional<User> findByEmailEqualsIgnoreCase(String email);


}




