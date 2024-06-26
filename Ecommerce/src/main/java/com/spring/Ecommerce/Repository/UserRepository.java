package com.spring.Ecommerce.Repository;

import com.spring.Ecommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String Email);
}
