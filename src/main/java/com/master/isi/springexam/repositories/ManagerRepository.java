package com.master.isi.springexam.repositories;

import com.master.isi.springexam.entities.ManagerEmployee;
import org.apache.catalina.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerEmployee,Long> {
}
