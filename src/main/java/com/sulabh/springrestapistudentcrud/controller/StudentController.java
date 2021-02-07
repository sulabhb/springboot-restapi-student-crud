package com.sulabh.springrestapistudentcrud.controller;

import com.sulabh.springrestapistudentcrud.entity.Student;
import com.sulabh.springrestapistudentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping(path = "{studentId}")
    public Optional<Student> getStudentById(@PathVariable("studentId") Long id){
        System.out.println(id);
        return studentService.getStudentByStudentId(id);
    }
    
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        System.out.println(id);
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(id,name,email);
    }
}
