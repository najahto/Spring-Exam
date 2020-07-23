package com.master.isi.springexam.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Employee_type")
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min=3, message = "minimum 3 lettre")
    private String firstName;
    @NotEmpty
    @Size(min=3, message = "minimum 3 lettre")
    private String lastName;
    @NotEmpty
    @Size(min=10,max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    private Date birthday;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "remuneration_id")
    private Remuneration remuneration;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
