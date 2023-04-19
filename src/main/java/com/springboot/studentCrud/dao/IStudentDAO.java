package com.springboot.studentCrud.dao;

import com.springboot.studentCrud.entity.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);

    void deleteById(int id);
}
