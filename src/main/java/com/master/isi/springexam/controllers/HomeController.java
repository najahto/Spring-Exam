package com.master.isi.springexam.controllers;

import com.master.isi.springexam.entities.Test;
import com.master.isi.springexam.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    TestRepository testRepository;
    @GetMapping(path = "/index")
    public String index(){
        return "index";
    }
}
