package com.aster.Main.Service;

import com.aster.Main.Entity.Cart;
import com.aster.Main.Entity.User;
import com.aster.Main.Repository.CartRepository;
import com.aster.Main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;

    @Override
    public User getOne(int id) {

        return userRepository.findById(id).get();
    }

    @Override
    public List<User> registerUser(User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    @Override
    public User loginUser(String mobile, String password) {
        User user=this.userRepository.findByMobileAndPassword(mobile,password);
        if(user!=null) {
            return user;
        }
        return null;
    }

    @Override
    public Cart getCart(int userId) {
        User user=this.userRepository.findById(userId).get();
        if(user!=null) {
            return this.cartRepository.findByUser(user);
        }
        return null;
    }

    @Override
    public boolean DeactivateUser(int id) {
        User user=this.userRepository.findById(id).get();
        user.setStatus(false);
        userRepository.delete(user);
        return false;
    }

}

