package com.springboot.studentCrud.dao;

import com.springboot.studentCrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDAO implements IStudentDAO {

    private EntityManager _entityManager;


    @Autowired
    public StudentDAO(EntityManager theEntityManager) {
        _entityManager = theEntityManager;
    }


    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = _entityManager.createQuery("from Student", Student.class);

        //This execute the query and get the result list
        List<Student> students = theQuery.getResultList();

        return students;
    }

    @Override
    public Student findById(int theId) {

        Student student = _entityManager.find(Student.class, theId);

        return student;
    }

    @Override
    public Student save(Student student) {

        Student dbStudent = _entityManager.merge(student);

        return dbStudent;
    }

    @Override
    public void deleteById(int theId) {

        Student student = _entityManager.find(Student.class, theId);

        _entityManager.remove(student);
    }
}
