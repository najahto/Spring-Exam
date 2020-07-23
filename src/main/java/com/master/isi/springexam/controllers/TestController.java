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

import java.util.List;

@Controller
public class TestController {
    @Autowired
    TestRepository testRepository;
    @GetMapping(path = "/test")
    public String test(Model model, @RequestParam(name ="page",defaultValue = "0") int page,@RequestParam(name = "size",defaultValue = "2") int size){
        Page<Test> tests = testRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("tests",tests.getContent());
        model.addAttribute("pages",new int[tests.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "test";
    }

    @GetMapping(path = "/deleteTest")
    public String delete(Long id){
        testRepository.deleteById(id);
        return "redirect:/test";
    }
}
