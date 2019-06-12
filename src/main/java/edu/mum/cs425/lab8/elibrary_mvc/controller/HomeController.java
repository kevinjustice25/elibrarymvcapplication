package edu.mum.cs425.lab8.elibrary_mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"","/elibrary"})
    public String homePage(){
        return "home/index";
    }
}
