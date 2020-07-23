package com.master.isi.springexam.controllers;

import com.master.isi.springexam.entities.Department;
import com.master.isi.springexam.entities.Employee;
import com.master.isi.springexam.entities.ManagerEmployee;
import com.master.isi.springexam.entities.NormalEmployee;
import com.master.isi.springexam.repositories.TestRepository;
import com.master.isi.springexam.services.DepartmentService;
import com.master.isi.springexam.services.EmployeeService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping(path = "/employees")
    public String list(Model model) {
        model.addAttribute("employees", employeeService.findAllEmployees());
        return "employees";
    }

    @GetMapping(path = "/employee_form")
    public String employeeForm(Employee employee,Model model) {
        model.addAttribute("departments",departmentService.getAllDepartments());
        return "employee_form";
    }


    @PostMapping(path = "/addEmployee")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model, @RequestParam("type") String role) {
        if (result.hasErrors()) {
            return "employee_form";
        }
        //departmentService.save(department);
        if(role.equals("ManagerEmployee")) {
            ManagerEmployee manager = new ManagerEmployee();
            manager.setFirstName(employee.getFirstName());
            manager.setLastName(employee.getLastName());
            manager.setEmail(employee.getEmail());
            manager.setGender(employee.getGender());
            manager.getBirthday(employee.getBirthday());
            manager.setRemuneration(employee.getRemuneration());
            manager.setDepartment(employee.getDepartment());
            this.employeeService.saveManager(manager);
        } else {
            NormalEmployee normalEmployee = new NormalEmployee();
            normalEmployee.setFirstName(employee.getFirstName());
            normalEmployee.setLastName(employee.getLastName());
            normalEmployee.setEmail(employee.getEmail());
            normalEmployee.getBirthday(employee.getBirthday());
            normalEmployee.setRemuneration(employee.getRemuneration());
            normalEmployee.setDepartment(employee.getDepartment());
            this.employeeService.saveNormalEmployee(normalEmployee);

        }
        return "redirect:employees";

    }

    @GetMapping(path = "/deleteEmployee")
    public String deleteEmployee(Long id){
        employeeService.deleteEmployee(id);
        return "redirect:departments";
    }
}