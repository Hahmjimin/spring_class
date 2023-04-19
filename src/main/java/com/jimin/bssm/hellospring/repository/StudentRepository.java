package com.jimin.bssm.hellospring.repository;

import com.jimin.bssm.hellospring.domain.Student;

import java.util.List;

public interface StudentRepository {
    Student save(Student student);

//    findById
    Student findById(Long id);

    List<Student> findAll();

//    findAll
}
