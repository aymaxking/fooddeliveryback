package com.blackhole.fooddelivery.demo.presentation.rest;
import com.blackhole.fooddelivery.demo.model.User;
import com.blackhole.fooddelivery.demo.services.IUserService;
import com.blackhole.fooddelivery.demo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

}
