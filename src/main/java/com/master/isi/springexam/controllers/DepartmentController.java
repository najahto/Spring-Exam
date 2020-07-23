package com.master.isi.springexam.controllers;

import com.master.isi.springexam.entities.Department;
import com.master.isi.springexam.entities.Test;
import com.master.isi.springexam.repositories.DepartmentRepository;
import com.master.isi.springexam.repositories.TestRepository;
import com.master.isi.springexam.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    @GetMapping(path = "/departments")
    public String list(Model model, @RequestParam(name ="page",defaultValue = "0") int page,@RequestParam(name = "size",defaultValue = "4") int size){
        Page<Department> departments = departmentService.findAll(page,size);
        model.addAttribute("departments", departments.getContent());
        model.addAttribute("pages",new int[departments.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "departments";
    }

    @GetMapping(path = "/department_form")
    public String departmentForm(Department department){
        //model.addAttribute("NavigationActiveClass",new Department());
        return "department_form";
    }

    @PostMapping(path = "/addDepartment")
    public String addDepartment(@Valid Department department, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "department_form";
        }
        departmentService.save(department);
        return "redirect:departments";
    }

    @GetMapping(path = "/editDepartment")
    public String editDepartment(Model model,long id){
        Department d = departmentService.findById(id).get();
        model.addAttribute("department",d);
        return "update_department";
    }

    @PostMapping(path = "/updateDepartment")
    public String updateDepartment(long id,@Valid Department department, BindingResult result, Model model){
        if (result.hasErrors()) {
            department.setId(id);
            return "update_department";
        }
        departmentService.save(department);
        return "redirect:departments";
    }

    @GetMapping(path = "/deleteDepartment")
    public String deleteDepartment(Long id){
        departmentService.deleteById(id);
        return "redirect:departments";
    }

}
