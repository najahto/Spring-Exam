package com.master.isi.springexam.services;

import com.master.isi.springexam.entities.Department;
import com.master.isi.springexam.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    @Transactional
    public Page<Department> findAll(Integer page, Integer size) {
        return departmentRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    @Transactional
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Department> findById(long id) {
        return departmentRepository.findById(id);
    }

    @Override
    @Transactional

    public void save(Department department) {
       departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        departmentRepository.deleteById(id);
    }


}
