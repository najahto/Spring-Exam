package com.master.isi.springexam.services;

import com.master.isi.springexam.entities.Department;
import com.master.isi.springexam.entities.Employee;
import com.master.isi.springexam.entities.ManagerEmployee;
import com.master.isi.springexam.entities.NormalEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Page<Employee> findAllEmployees(Integer  page, Integer size);
    List<Employee> findAllEmployees();
    Employee findEmployeeById(long id) ;
    void saveEmployee(Employee employee);
    void deleteEmployee(long id);

    Page<ManagerEmployee> findAllManagers(Integer  page, Integer size);
    List<ManagerEmployee> findAllManagers();
    ManagerEmployee findManagerById(long id) ;
    void saveManager(ManagerEmployee employee);
    void deleteManagerById(long id);


    Page<NormalEmployee> getAllEmployees(Integer  page, Integer size);
    List<NormalEmployee> getAllEmployees();
    NormalEmployee findNormalEmployeeById(long id) ;
    void saveNormalEmployee(NormalEmployee employee);
    void deleteNormalEmployeeById(long id);

    

}
