package com.blackhole.fooddelivery.demo;

import com.blackhole.fooddelivery.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
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
                antMatchers("/categories").permitAll().
                antMatchers("/").permitAll().
                antMatchers("/places").permitAll().
                antMatchers("/login").permitAll().
                antMatchers("/types").permitAll().
                antMatchers("/users").permitAll().
                antMatchers("/menus").permitAll()
                .anyRequest().authenticated();
//        http.authorizeRequests().
//                antMatchers("/").permitAll().
//                antMatchers("/login").permitAll();
//                antMatchers("/welcome").hasAnyAuthority("ADMIN","CLIENT").
//                antMatchers("/admin/**").hasAuthority("ADMIN").
//                antMatchers("/places/**").hasAuthority("CLIENT");
//                anyRequest().authenticated().
//                and().csrf().disable().
//                formLogin().loginPage("/login").
//                failureUrl("/login?error=true").
//                defaultSuccessUrl("/welcome").
//                usernameParameter("username").
//                passwordParameter("password").
//                and().logout().logoutRequestMatcher(new
//                        AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").
//                and().exceptionHandling().accessDeniedPage("/access-denied");

    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**",
                "/images/**");
    }
}
