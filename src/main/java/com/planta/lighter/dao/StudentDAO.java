package com.planta.lighter.dao;

import java.util.List;

import com.planta.lighter.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();
}
