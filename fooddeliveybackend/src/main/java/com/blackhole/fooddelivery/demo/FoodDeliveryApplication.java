package com.blackhole.fooddelivery.demo;

import com.blackhole.fooddelivery.demo.domaine.vo.*;
import com.blackhole.fooddelivery.demo.services.*;
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
    private ITypeService typeService;
    @Autowired
    private IPLaceService pLaceService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private ISubMenuService subMenuService;



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
        UserVo admin1 = new UserVo("admin1@gmail.com", "admin1", Arrays.asList(roleAdmin));
        UserVo client1 = new UserVo("client1@gmail.com", "client1", Arrays.asList(roleClient));
        userService.save(admin1);
        userService.save(client1);
        // *************
//        CategoryVo category =new CategoryVo("Meals");
//
        categoryService.save(new CategoryVo("Meals",null));
        categoryService.save(new CategoryVo("Drinks",null));
        categoryService.save(new CategoryVo("Dessert",null));
//        categoryService.save(category);
//
//
//
//
//
//
//
//        typeService.save(new TypeVo("Burgers",null,category));
//        typeService.save(new TypeVo("Friend Chicken",null, category));
//        typeService.save(new TypeVo("Soft Drinks",null, category));
//        typeService.save(new TypeVo("Puddings",null, category));
//
//
        pLaceService.save(new PlaceVo("McDonalds",null,"Fast Food - Burgers"));
        pLaceService.save(new PlaceVo("KFC",null,"Fast Food - Fried Chicken"));
        pLaceService.save(new PlaceVo("Burger King",null,"Fast Food - Burgers"));
//
//        menuService.save(new MenuVo("Burgers"));
//        menuService.save(new MenuVo("Drinks"));
//        menuService.save(new MenuVo("Desserts"));
//        menuService.save(new MenuVo("Chawarma"));
//        menuService.save(new MenuVo("Salad"));
//
//        subMenuService.save(new SubMenuVo("Big Mac",15.50,null));
//        subMenuService.save(new SubMenuVo("Big Tasty",18.00,null));
//        subMenuService.save(new SubMenuVo("McChicken",20.00,null));
//        subMenuService.save(new SubMenuVo("Double CheeseBurger",13.50,null));












    }
}
