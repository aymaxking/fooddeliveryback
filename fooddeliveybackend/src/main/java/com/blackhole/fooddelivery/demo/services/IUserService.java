package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void save(UserVo user);
    void saveClient(ClientVo user);
    void savePlace(PlaceVo user);
    void saveDelivery(DeliveryVo user);
    void delete(Long id);
    void save(RoleVo role);
    UserVo getById(Long id);
    List<UserVo> getAllUsers();
    List<RoleVo> getAllRoles();
    RoleVo getRoleByName(String role);
    UserVo getUserByUsername(String username);
    void cleanDataBase();
    UserVo login(UserVo user);
}