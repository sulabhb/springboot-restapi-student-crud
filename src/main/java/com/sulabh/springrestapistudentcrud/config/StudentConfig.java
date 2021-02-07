package com.sulabh.springrestapistudentcrud.config;

import com.sulabh.springrestapistudentcrud.entity.Student;
import com.sulabh.springrestapistudentcrud.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student sulabh = new Student(
                    "Sulabh",
                    "sulabh@gmail.com",
                    LocalDate.of(2000, 02, 13));
            Student durlabh = new Student("durlabh",
                    "durlabh@gmail.com",
                    LocalDate.of(2003, 02, 13));

            repository.saveAll(
                    List.of(sulabh,durlabh)
            );

        };



    }
}
