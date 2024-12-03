package com.solarvalley.controller;

import com.solarvalley.dto.UserDTO;
import com.solarvalley.entities.User;
import com.solarvalley.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Value("${logoUrl}")
    private String logoUrl;

    @Value("${aboutUs1}")
    private String aboutUs1;

    @Value("${aboutUs2}")
    private String aboutUs2;

    @Value("${founder1}")
    private String founder1;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("logoUrl", logoUrl);
        model.addAttribute("aboutUs1", aboutUs1);
        model.addAttribute("aboutUs2", aboutUs2);
        model.addAttribute("founder1", founder1);
        return "home";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model){
        model.addAttribute("logoUrl", logoUrl);
        model.addAttribute("aboutUs1", aboutUs1);
        model.addAttribute("aboutUs2", aboutUs2);
        model.addAttribute("founder1", founder1);
        return "about-us";
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
