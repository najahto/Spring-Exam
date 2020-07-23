package com.master.isi.springexam.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@DiscriminatorValue("M")
public class ManagerEmployee extends Employee{

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Employee> employees;
}
