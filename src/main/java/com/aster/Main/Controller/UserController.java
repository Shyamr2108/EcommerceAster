package com.aster.Main.Controller;

import com.aster.Main.Entity.Cart;
import com.aster.Main.Entity.User;
import com.aster.Main.Login;
import com.aster.Main.Service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user){
            List<User> users=this.userServiceImpl.registerUser(user);
            return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);

    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody Login credentials){
        String mobile=credentials.getMobile();
        String password=credentials.getPassword();
        User user=this.userServiceImpl.loginUser(mobile,password);
        if(user==null){
            return null;
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

}
