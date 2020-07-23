package com.master.isi.springexam.repositories;

import com.master.isi.springexam.entities.NormalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NormalEmployeeRepository extends JpaRepository<NormalEmployee,Long> {
}
