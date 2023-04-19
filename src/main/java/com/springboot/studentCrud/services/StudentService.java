package com.springboot.studentCrud.services;

import com.springboot.studentCrud.dao.StudentDAO;
import com.springboot.studentCrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private StudentDAO _studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        _studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return _studentDAO.findAll();
    }

    @Override
    public Student findById(int theId) {
        return _studentDAO.findById(theId);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return _studentDAO.save(student);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        _studentDAO.deleteById(theId);
    }
}
