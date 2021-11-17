package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.RoleVo;
import com.blackhole.fooddelivery.demo.domaine.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void save(UserVo user);
    void save(RoleVo role);
    List<UserVo> getAllUsers();
    List<RoleVo> getAllRoles();
    RoleVo getRoleByName(String role);
    void cleanDataBase();
}