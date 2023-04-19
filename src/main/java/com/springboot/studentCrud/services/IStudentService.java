package com.springboot.studentCrud.services;

import com.springboot.studentCrud.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(int theId);

    Student save(Student student);

    void deleteById(int id);
}
