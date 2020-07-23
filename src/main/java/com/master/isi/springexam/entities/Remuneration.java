package com.master.isi.springexam.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public abstract class Remuneration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RemunerationType Type;

    @OneToMany(mappedBy = "remuneration")
    private List<Employee> employees;


}
