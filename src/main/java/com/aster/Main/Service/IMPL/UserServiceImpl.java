package com.aster.Main.Service.IMPL;

import com.aster.Main.Config.JwtService;
import com.aster.Main.DTO.AuthenticationRequest;
import com.aster.Main.DTO.AuthenticationResponse;
import com.aster.Main.DTO.RegisterUser;
import com.aster.Main.Entity.Role;
import com.aster.Main.Entity.User;
import com.aster.Main.Repository.UserRepository;
import com.aster.Main.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


//    @Override
//    public User getOne(int id) {
//
//        return userRepository.findById(id).get();
//    }
//
//    @Override
//    public List<User> registerUser(User user) {
//        userRepository.save(user);
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User loginUser(String mobile, String password) {
//        User user=this.userRepository.findByMobileAndPassword(mobile,password);
//        if(user!=null) {
//            return user;
//        }
//        return null;
//    }
//
//
//    @Override
//    public boolean DeactivateUser(int id) {
//        User user=this.userRepository.findById(id).get();
//        user.setStatus(false);
//        userRepository.delete(user);
//        return false;
//    }

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterUser request) {
        log.info("new user is registered{}",request.getFirstname());
        var user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .status(true)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}

