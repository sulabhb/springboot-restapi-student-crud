package com.sulabh.springrestapistudentcrud.service;

import com.sulabh.springrestapistudentcrud.entity.Student;
import com.sulabh.springrestapistudentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);

        System.out.println(student);
    }

    public void deleteStudent(Long id) {
        System.out.println(id);
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Student with id "+ id + "doesnt exists");
        }
        studentRepository.deleteById(id);
    }

    public Optional<Student> getStudentByStudentId(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(
                        ()-> new IllegalStateException(
                                "student with id "+ id +" doesn't exist"
                        )
                );
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> optionalStudent = studentRepository
                    .findStudentByEmail(email);
            if(optionalStudent.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
