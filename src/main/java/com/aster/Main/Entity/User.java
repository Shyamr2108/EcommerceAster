package com.aster.Main.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int uid;
   @Size(max = 15)
   @NotNull
   private String firstName;
   private String lastName;
   @Email
   private String email;
   @Size(max = 10 , min = 10)
   private String mobile;
   @Pattern(regexp = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$", message ="worng password pattern" )
   private String password;
   private boolean status;

   @OneToOne(mappedBy = "user")
    private Cart cart;

}
