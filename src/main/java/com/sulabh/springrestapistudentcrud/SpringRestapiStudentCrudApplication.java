package com.sulabh.springrestapistudentcrud;

import com.sulabh.springrestapistudentcrud.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringRestapiStudentCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestapiStudentCrudApplication.class, args);
    }



}
