package com.master.isi.springexam.repositories;

import com.master.isi.springexam.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
