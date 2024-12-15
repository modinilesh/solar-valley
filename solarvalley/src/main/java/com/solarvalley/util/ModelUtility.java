package com.solarvalley.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ModelUtility {
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

    @Value("${aboutUsHeader}")
    private String aboutUsHeader;

    public void setModel(Model model){
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

        //header
        model.addAttribute("aboutUsHeader", aboutUsHeader);

        //footer
        model.addAttribute("footer", footer);
    }
}
