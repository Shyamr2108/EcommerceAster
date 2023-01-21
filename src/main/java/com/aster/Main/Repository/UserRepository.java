package com.aster.Main.Repository;

import com.aster.Main.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByMobileAndPassword(String mobile , String password);
}
