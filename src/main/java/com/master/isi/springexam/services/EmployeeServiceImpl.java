package com.master.isi.springexam.services;

import com.master.isi.springexam.entities.Employee;
import com.master.isi.springexam.entities.ManagerEmployee;
import com.master.isi.springexam.entities.NormalEmployee;
import com.master.isi.springexam.repositories.EmployeeRepository;
import com.master.isi.springexam.repositories.ManagerRepository;
import com.master.isi.springexam.repositories.NormalEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private NormalEmployeeRepository normalEmployeeRepository;

    @Override
    @Transactional
    public Page<Employee> findAllEmployees(Integer page, Integer size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    @Transactional
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    @Transactional
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Page<ManagerEmployee> findAllManagers(Integer page, Integer size) {
        return managerRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    @Transactional
    public List<ManagerEmployee> findAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    @Transactional
    public ManagerEmployee findManagerById(long id) {
        return managerRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void saveManager(ManagerEmployee employee) {
        managerRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteManagerById(long id) {
        managerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Page<NormalEmployee> getAllEmployees(Integer page, Integer size) {
        return normalEmployeeRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    @Transactional
    public List<NormalEmployee> getAllEmployees() {
        return normalEmployeeRepository.findAll();
    }

    @Override
    @Transactional
    public NormalEmployee findNormalEmployeeById(long id) {
        return normalEmployeeRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void saveNormalEmployee(NormalEmployee employee) {
        normalEmployeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteNormalEmployeeById(long id) {
        normalEmployeeRepository.deleteById(id);
    }
}
