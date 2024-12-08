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

    @Value("${hero}")
    private String hero;

    @Value("${p1}")
    private String p1;

    @Value("${p2}")
    private String p2;

    @Value("${p3}")
    private String p3;

    @Value("${p4}")
    private String p4;

    @Value("${p5}")
    private String p5;

    @Value("${p6}")
    private String p6;

    @Value("${p7}")
    private String p7;

    @Value("${p8}")
    private String p8;

    @Value("${footer}")
    private String footer;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("logoUrl", logoUrl);
        model.addAttribute("aboutUs1", aboutUs1);
        model.addAttribute("aboutUs2", aboutUs2);
        model.addAttribute("founder1", founder1);
        model.addAttribute("hero", hero);

        //associated partners
        model.addAttribute("p1", p1);
        model.addAttribute("p2", p2);
        model.addAttribute("p3", p3);
        model.addAttribute("p4", p4);
        model.addAttribute("p5", p5);
        model.addAttribute("p6", p6);
        model.addAttribute("p7", p7);
        model.addAttribute("p8", p8);

        //footer
        model.addAttribute("footer", footer);
        return "home";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model){
        model.addAttribute("logoUrl", logoUrl);
        model.addAttribute("aboutUs1", aboutUs1);
        model.addAttribute("aboutUs2", aboutUs2);
        model.addAttribute("founder1", founder1);
        model.addAttribute("hero", hero);
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
