package com.jimin.bssm.hellospring.repository;

import com.jimin.bssm.hellospring.domain.Student;

public interface StudentRepository {
    Student save(Student student);

//    findById
    Student findById(Long id);

//    findAll
}
