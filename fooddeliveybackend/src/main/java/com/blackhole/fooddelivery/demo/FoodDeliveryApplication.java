package com.blackhole.fooddelivery.demo;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;
import com.blackhole.fooddelivery.demo.domaine.vo.RoleVo;
import com.blackhole.fooddelivery.demo.domaine.vo.UserVo;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import com.blackhole.fooddelivery.demo.services.IPLaceService;
import com.blackhole.fooddelivery.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Arrays;

@SpringBootApplication
@CrossOrigin("*")
public class FoodDeliveryApplication implements CommandLineRunner {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IPLaceService pLaceService;



    public static void main(String[] args) {
        SpringApplication.run(FoodDeliveryApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
        userService.cleanDataBase();
        userService.save(new RoleVo("ADMIN"));
        userService.save(new RoleVo("CLIENT"));
        RoleVo roleAdmin = userService.getRoleByName("ADMIN");
        RoleVo roleClient = userService.getRoleByName("CLIENT");
        UserVo admin1 = new UserVo("admin1", "admin1", Arrays.asList(roleAdmin));
        UserVo client1 = new UserVo("client1", "client1", Arrays.asList(roleClient));
        userService.save(admin1);
        userService.save(client1);
        // *************
        categoryService.save(new CategoryVo("Meals"));
        categoryService.save(new CategoryVo("Drinks"));
        categoryService.save(new CategoryVo("Dessert"));

        pLaceService.save(new PlaceVo("McDonalds",null,"Fast Food - Burgers"));
        pLaceService.save(new PlaceVo("KFC",null,"Fast Food - Fried Chicken"));
        pLaceService.save(new PlaceVo("Burger King",null,"Fast Food - Burgers"));




    }
}
