package com.solarvalley.controller;

import com.solarvalley.dto.UserDTO;
import com.solarvalley.entities.User;
import com.solarvalley.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/contact-us")
    public String contactUs(@ModelAttribute("userDTO") UserDTO userDTO, ModelMap modelmap){
        User user = userService.createUser(userDTO);
        return "home";
    }
}
