package com.aster.Main.Controller;

import com.aster.Main.DTO.AuthenticationRequest;
import com.aster.Main.DTO.AuthenticationResponse;
import com.aster.Main.DTO.RegisterUser;
import com.aster.Main.Service.IMPL.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

//    @PostMapping("/register")
//    public ResponseEntity<?> register(@Valid @RequestBody User user){
////            String pass=user.getPassword();
////            passwordEncoder().encode(pass);
//            List<User> users=this.userServiceImpl.registerUser(user);
//            return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
//
//    }
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@Valid @RequestBody Login credentials){
//        String mobile=credentials.getMobile();
//        String password=credentials.getPassword();
//        User user=this.userServiceImpl.loginUser(mobile,password);
//        if(user==null){
//            return null;
//        }
//        return new ResponseEntity<User>(user,HttpStatus.OK);
//    }
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterUser request
    ) {
        return ResponseEntity.ok(userServiceImpl.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(userServiceImpl.authenticate(request));
    }

}
