package com.example.testtask.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/person";
    }

    @GetMapping("/home")
    public String home( Model model) {
        return "redirect:/person";
    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }

}