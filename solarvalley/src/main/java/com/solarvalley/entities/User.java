package com.solarvalley.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sv_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "message")
    private String message;

}
