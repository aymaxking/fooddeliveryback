package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByRole(String role);
    List<Role> findAll();
}