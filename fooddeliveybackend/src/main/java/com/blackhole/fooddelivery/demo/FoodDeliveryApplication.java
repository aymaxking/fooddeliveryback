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

        TypeVo type1=new TypeVo("Burgers",null);
        TypeVo type2=new TypeVo("Fiend Chicken",null);
        TypeVo type3=new TypeVo("Soft Drinks",null);
        TypeVo type4=new TypeVo("Püddings",null);


        typeService.save(type1);
        typeService.save(type2);
        typeService.save(type3);
        typeService.save(type4);

        CategoryVo category1 = new CategoryVo("Meals");
        CategoryVo category2 =new CategoryVo("Drinks");
        CategoryVo category3 =new CategoryVo("Dessert");



        category1.addtype(typeService.getAll().get(0));
        category2.addtype(typeService.getAll().get(1));
        category3.addtype(typeService.getAll().get(2));
        category3.addtype(typeService.getAll().get(3));

        categoryService.save(category1);
        categoryService.save(category2);
        categoryService.save(category3);

        SubMenuVo subMenu1 = new SubMenuVo("Big Mac",15.50,null);
        SubMenuVo subMenu2 = new SubMenuVo("Big Tasty",18.00,null);
        SubMenuVo subMenu3 = new SubMenuVo("McChicken",20.00,null);
        SubMenuVo subMenu4 = new SubMenuVo("Double CheeseBurger",13.50,null);

        SubMenuVo subMenu5 = new SubMenuVo("Coca Cola",10.00,null);
        SubMenuVo subMenu6 = new SubMenuVo("Hot Tea",25.00,null);
        SubMenuVo subMenu7 = new SubMenuVo("Hot Chocolate",18.50,null);
        SubMenuVo subMenu8 = new SubMenuVo("Mango Pineapple Smoothie",13.50,null);

        SubMenuVo subMenu9 = new SubMenuVo("Brookie",10.00,null);
        SubMenuVo subMenu10 = new SubMenuVo("Crousti' Kream Snickers",25.00,null);
        SubMenuVo subMenu11 = new SubMenuVo("Muffin Nutella",18.50,null);

        SubMenuVo subMenu12 = new SubMenuVo("King Chicken Salad",13.50,null);
        SubMenuVo subMenu13= new SubMenuVo("King Garden Salad",10.00,null);




        subMenuService.save(subMenu1);
        subMenuService.save(subMenu2);
        subMenuService.save(subMenu3);
        subMenuService.save(subMenu4);
        subMenuService.save(subMenu5);
        subMenuService.save(subMenu6);
        subMenuService.save(subMenu7);
        subMenuService.save(subMenu8);
        subMenuService.save(subMenu9);
        subMenuService.save(subMenu10);
        subMenuService.save(subMenu11);
        subMenuService.save(subMenu12);
        subMenuService.save(subMenu13);




        MenuVo menu1=new MenuVo("Burgers");
        MenuVo menu2=new MenuVo("Drinks");
        MenuVo menu3=new MenuVo("Desserts");
        MenuVo menu5=new MenuVo("Salad");

        menu1.addsubmenu(subMenu1);
        menu1.addsubmenu(subMenu2);
        menu1.addsubmenu(subMenu3);
        menu1.addsubmenu(subMenu4);

        menu2.addsubmenu(subMenu5);
        menu2.addsubmenu(subMenu6);
        menu2.addsubmenu(subMenu7);
        menu2.addsubmenu(subMenu8);

        menu3.addsubmenu(subMenu9);
        menu3.addsubmenu(subMenu10);
        menu3.addsubmenu(subMenu11);

        menu5.addsubmenu(subMenu12);
        menu5.addsubmenu(subMenu13);

        menuService.save(menu1);
        menuService.save(menu2);
        menuService.save(menu3);
        menuService.save(menu5);

        PlaceVo place1=new PlaceVo("McDonalds",null,"Fast Food - Burgers");
        PlaceVo place2=new PlaceVo("KFC",null,"Fast Food - Fried Chicken");
        PlaceVo place3=new PlaceVo("Burger King",null,"Fast Food - Burgers");

        place1.addmenu(menu1);
        place1.addmenu(menu2);
        place2.addmenu(menu3);
        place3.addmenu(menu5);


        pLaceService.save(place1);
        pLaceService.save(place2);
        pLaceService.save(place3);


    }
}
