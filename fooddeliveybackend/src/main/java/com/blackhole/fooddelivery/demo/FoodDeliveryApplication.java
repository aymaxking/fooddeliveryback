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

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.security.SecureRandom;
import java.util.Arrays;

@SpringBootApplication
@CrossOrigin("*")
public class FoodDeliveryApplication implements CommandLineRunner {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IClientService clientService;
    @Autowired
    private IDeliveryService deliveryService;
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

    public static String GenerateRandomPassword()
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
    @Override
    public void run(String... args) throws Exception {
     //userService.save(new UserVo("admin@gmail.com","admin","admin"));

    }
}
