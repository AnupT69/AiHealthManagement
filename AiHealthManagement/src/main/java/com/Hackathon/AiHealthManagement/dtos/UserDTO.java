package com.Hackathon.AiHealthManagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
private String name;
private String email;
private String password;
}
