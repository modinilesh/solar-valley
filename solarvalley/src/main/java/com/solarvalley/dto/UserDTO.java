package com.solarvalley.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String message;
}
