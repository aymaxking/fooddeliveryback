package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}
