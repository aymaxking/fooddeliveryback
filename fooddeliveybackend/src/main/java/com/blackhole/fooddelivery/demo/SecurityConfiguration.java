package com.blackhole.fooddelivery.demo;

import com.blackhole.fooddelivery.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.lang.reflect.Method;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IUserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests().
              antMatchers("/rest/**").
               permitAll();
////login
//        http.authorizeRequests().
//                antMatchers("/rest/auth/login").
//                permitAll();
////ADMIN
//        http.authorizeRequests().
//                antMatchers("/rest/categories").
//                hasAuthority("ADMIN");
//
//        http.authorizeRequests().
//                antMatchers("/rest/users").
//                hasAuthority("ADMIN");
//
//        http.authorizeRequests().
//                antMatchers("/rest/types").
//                hasAuthority("ADMIN");
//
//        http.authorizeRequests().
//                antMatchers("/rest/places").
//                hasAuthority("ADMIN");
//
//        http.authorizeRequests().
//                antMatchers(HttpMethod.GET,"/rest/menus").
//                hasAuthority("ADMIN");
//
//        http.authorizeRequests().
//                antMatchers(HttpMethod.GET,"/rest/submenus").
//                hasAuthority("ADMIN");
//
////PLACE
//        http.authorizeRequests().
//                antMatchers(HttpMethod.GET,"/rest/categories").
//                hasAuthority("PLACE");
//
//        http.authorizeRequests().
//                antMatchers(HttpMethod.GET,"/rest/types").
//                hasAuthority("PLACE");
//
//        http.authorizeRequests().
//                antMatchers("/rest/places").
//                hasAuthority("PLACE");
//
//        http.authorizeRequests().
//                antMatchers("/rest/menus").
//                hasAuthority("PLACE");
//
//        http.authorizeRequests().
//                antMatchers("/rest/submenus").
//                hasAuthority("PLACE");
//
//
//
//
//        http.authorizeRequests().
//                antMatchers("/rest/**").permitAll();


    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**",
                "/images/**");
    }
}
