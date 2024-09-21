package com.flyroute.fly.repository;

import com.flyroute.fly.dto.UserDto;
import com.flyroute.fly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

 Optional<User> findById(int id);

}




