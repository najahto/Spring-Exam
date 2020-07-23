package com.master.isi.springexam.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@DiscriminatorValue("N")
public class NormalEmployee extends Employee {
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
