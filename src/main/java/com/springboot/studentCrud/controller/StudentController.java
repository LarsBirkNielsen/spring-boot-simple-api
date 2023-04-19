package com.springboot.studentCrud.controller;

import com.springboot.studentCrud.entity.Student;
import com.springboot.studentCrud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService _studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        _studentService = studentService;
    }


    @GetMapping("/students")
    public List<Student> findAll() {
        return _studentService.findAll();
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student student = _studentService.findById(studentId);

        if (student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        return student;
    }


    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {

        //I set the id to 0 to force a save of new item ... instead of update

        student.setId(0);

        Student dbStudent = _studentService.save(student);

        return dbStudent;
    }


    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {

        Student dbStudent = _studentService.save(student);

        return dbStudent;
    }


    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        Student student = _studentService.findById(studentId);

        // throw exception if null

        if (student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        _studentService.deleteById(studentId);

        return "Deleted student id - " + studentId;
    }

}

