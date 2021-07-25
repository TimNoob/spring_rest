package com.demo.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerHomePage
{
    @GetMapping("/")
    public String getHomePage(Model model)
    {
        model.addAttribute("title", "home");
        return "home";
    }
}