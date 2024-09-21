package com.flyroute.fly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "data_of_birth",nullable = false)
    private String dataOfBirth;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

}
