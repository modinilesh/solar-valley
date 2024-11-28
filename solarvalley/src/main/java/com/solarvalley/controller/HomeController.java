package com.solarvalley.controller;

import com.solarvalley.dto.UserDTO;
import com.solarvalley.entities.User;
import com.solarvalley.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/contact-us")
    public String contactUs(@ModelAttribute("userDTO") UserDTO userDTO, RedirectAttributes redirectAttributes){
        try {
            User user = userService.createUser(userDTO);
            redirectAttributes.addFlashAttribute("successMessage", "Thank you for reaching out! We will contact you soon.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/home#contact";
    }
}
