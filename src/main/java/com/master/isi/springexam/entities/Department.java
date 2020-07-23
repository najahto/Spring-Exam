package com.master.isi.springexam.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=3, message = "minimum 3 lettre")
    private String name;
    @Enumerated(EnumType.STRING)
    private DepartmentType type;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
