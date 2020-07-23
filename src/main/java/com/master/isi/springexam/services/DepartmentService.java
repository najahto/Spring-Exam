package com.master.isi.springexam.services;

import com.master.isi.springexam.entities.Department;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Page<Department> findAll(Integer  page, Integer size);

    List<Department> getAllDepartments();

    Optional<Department> findById(long id) ;

    void save(Department department);

    void deleteById(long id);

}
