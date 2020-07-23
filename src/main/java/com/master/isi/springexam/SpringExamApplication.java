package com.master.isi.springexam;

import com.master.isi.springexam.entities.Test;
import com.master.isi.springexam.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExamApplication implements CommandLineRunner {
    @Autowired
    private TestRepository testRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringExamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        testRepository.save(new Test(1,"test"));
//        testRepository.save(new Test(2,"test2"));
        testRepository.findAll().forEach(p->{
            System.out.println(p.getName().toString());
        });
    }
}
