package com.master.isi.springexam.repositories;

import com.master.isi.springexam.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Long> {

}
