package com.blackhole.fooddelivery.demo;

import com.blackhole.fooddelivery.demo.domaine.vo.*;
import com.blackhole.fooddelivery.demo.model.Place;
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
        userService.save(new RoleVo("PLACE"));
        userService.save(new RoleVo("DELIVERY"));

        RoleVo roleAdmin = userService.getRoleByName("ADMIN");
        RoleVo roleClient = userService.getRoleByName("CLIENT");
        RoleVo rolePlace = userService.getRoleByName("PLACE");
        RoleVo roleDelivery = userService.getRoleByName("DELIVERY");

        UserVo admin1 = new UserVo("admin1@gmail.com", "admin1", Arrays.asList(roleAdmin));
        UserVo client1 = new UserVo("client1@gmail.com", "client1", Arrays.asList(roleClient));
        UserVo iplace1 = new UserVo("place1@gmail.com", "place1", Arrays.asList(rolePlace));
        UserVo delivery1 = new UserVo("delivery1@gmail.com", "delivery1", Arrays.asList(roleDelivery));

        userService.save(admin1);
        userService.save(client1);
        userService.save(iplace1);
        userService.save(delivery1);



        CategoryVo category1 = new CategoryVo("Meals");
        CategoryVo category2 =new CategoryVo("Drinks");
        CategoryVo category3 =new CategoryVo("Dessert");


        category1.addtype(new TypeVo("Burgers",null));
        category2.addtype(new TypeVo("Fiend Chicken",null));
        category3.addtype(new TypeVo("Soft Drinks",null));
        category3.addtype(new TypeVo("Püddings",null));

        categoryService.save(category1);
        categoryService.save(category2);
        categoryService.save(category3);

        PlaceVo place1 = new PlaceVo("place test",null,"description placetest");

        MenuVo menuVo = new MenuVo("Burgers");

        menuVo.addsubmenu(new SubMenuVo("Burger1",12,null));
        menuVo.addsubmenu(new SubMenuVo("Burger2",20,null));
        menuVo.addsubmenu(new SubMenuVo("Burger3",19,null));
        menuVo.addsubmenu(new SubMenuVo("Burger3",19,null));
        menuVo.addsubmenu(new SubMenuVo("Burger3",19,null));



        MenuVo menuVo2 = new MenuVo("Drinks");

        menuVo2.addsubmenu(new SubMenuVo("Drink1",25,null));
        menuVo2.addsubmenu(new SubMenuVo("Drink2",27,null));
        menuVo2.addsubmenu(new SubMenuVo("Drink3",35,null));

        place1.addmenu(menuVo2);
        place1.addmenu(menuVo);

        pLaceService.save(place1);




    }
}
