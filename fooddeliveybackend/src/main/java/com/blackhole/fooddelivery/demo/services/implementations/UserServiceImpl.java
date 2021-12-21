package com.blackhole.fooddelivery.demo.services.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.blackhole.fooddelivery.demo.dao.*;
import com.blackhole.fooddelivery.demo.domaine.converter.*;
import com.blackhole.fooddelivery.demo.domaine.vo.*;
import com.blackhole.fooddelivery.demo.model.*;
import com.blackhole.fooddelivery.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository
            roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
//        if(user==null) throw new UsernameNotFoundException(username);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new
                org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked,
                getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> springSecurityAuthorities = new ArrayList<>();
        for (Role r : roles) {
            springSecurityAuthorities.add(new
                    SimpleGrantedAuthority(r.getRole()));
        }
        return springSecurityAuthorities;
    }

    @Override
    public void save(UserVo userVo) {
        User user = UserConverter.toBo(userVo);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> rolesPersist = new ArrayList<>();
        for (Role role : user.getRoles()) {
            Role userRole = roleRepository.findByRole(role.getRole()).get(0);
            rolesPersist.add(userRole);
        }
        user.setRoles(rolesPersist);
        userRepository.save(user);
    }

    @Override
    public void savePlace(PlaceVo userVo) {
        Place user = PlaceConverter.toBo(userVo);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> rolesPersist = new ArrayList<>();
        for (Role role : user.getRoles()) {
            Role userRole = roleRepository.findByRole(role.getRole()).get(0);
            rolesPersist.add(userRole);
        }
        user.setRoles(rolesPersist);
        placeRepository.save(user);
    }
    @Override
    public void saveClient(ClientVo userVo) {
        Client user = ClientConverter.toBo(userVo);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> rolesPersist = new ArrayList<>();
        for (Role role : user.getRoles()) {
            Role userRole = roleRepository.findByRole(role.getRole()).get(0);
            rolesPersist.add(userRole);
        }
        user.setRoles(rolesPersist);
        clientRepository.save(user);
    }

    @Override
    public void saveDelivery(DeliveryVo userVo) {
        Delivery user = DeliveryConverter.toBo(userVo);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> rolesPersist = new ArrayList<>();
        for (Role role : user.getRoles()) {
            Role userRole = roleRepository.findByRole(role.getRole()).get(0);
            rolesPersist.add(userRole);
        }
        user.setRoles(rolesPersist);
        deliveryRepository.save(user);
    }
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void save(RoleVo roleVo) {
        roleRepository.save(RoleConverter.toBo(roleVo));
    }

    @Override
    public UserVo getById(Long id) {
            boolean trouve = userRepository.existsById(id);
            if (!trouve)
                return null;
            return UserConverter.toVo(userRepository.getOne(id));
    }


    @Override
    public List<UserVo> getAllUsers() {
        return UserConverter.toVoList(userRepository.findAll());
    }
    @Override
    public List<RoleVo> getAllRoles() {
        return RoleConverter.toVoList(roleRepository.findAll());
    }

    @Override
    public RoleVo getRoleByName(String role) {
        return RoleConverter.toVo(roleRepository.findByRole(role).get(0));
    }

    @Override
    public UserVo getUserByUsername(String username) {
        return UserConverter.toVo(userRepository.findByUsername(username));
    }

    @Override
    public void cleanDataBase() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @Override
    public UserVo login(UserVo user) {
        return UserConverter.toVo(userRepository.findByUsernameEqualsAndPasswordEquals(user.getUsername(),user.getPassword()));
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
