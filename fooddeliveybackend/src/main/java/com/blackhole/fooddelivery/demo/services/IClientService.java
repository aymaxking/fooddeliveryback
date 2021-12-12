package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.domaine.vo.RoleVo;
import com.blackhole.fooddelivery.demo.domaine.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IClientService extends UserDetailsService {
    void save(ClientVo user);
    void delete(Long id);
    ClientVo getById(Long id);
    List<UserVo> getAllUsers();
    List<RoleVo> getAllRoles();
    RoleVo getRoleByName(String role);
    UserVo getUserByUsername(String username);
    void cleanDataBase();
    UserVo login(UserVo user);
}