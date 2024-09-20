package com.flyroute.fly.repository;

import com.flyroute.fly.dto.UserDto;
import com.flyroute.fly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.name = :name AND u.country = :country")
    List<User> findByNameAndCountry(
            @Param("name") String name,
            @Param("country") String country);


}




