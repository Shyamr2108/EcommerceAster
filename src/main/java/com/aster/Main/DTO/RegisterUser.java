package com.aster.Main.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {
    private String firstname;
    private String lastname;
    private String mobile;
    private String email;
    private String password;
}
