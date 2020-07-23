package com.master.isi.springexam.controllers;

import com.master.isi.springexam.repositories.TestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {
    TestRepository testRepository;

    @GetMapping(path = "/login")
    public String login(@RequestParam Optional<String> error,Model model){
        model.addAttribute("error",error);
        return "login";
    }
}
