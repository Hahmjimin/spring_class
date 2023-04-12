package com.jimin.bssm.hellospring.service;

import com.jimin.bssm.hellospring.domain.Student;
import com.jimin.bssm.hellospring.repository.MemoryStudentRepository;
import com.jimin.bssm.hellospring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final MemoryStudentRepository repository;

    @Autowired
    public StudentService(MemoryStudentRepository repository) {
        this.repository = repository;
    }

    //학생 등록
    public Long edit(Student student) {
        //1. 학번이 중복되는지?
        validateDuplicateStudent(student);
        //2. 학생 등록
        Student saveStudent = repository.save(student);
        System.out.println(saveStudent.getId());
        return saveStudent.getId();
    }

    private void validateDuplicateStudent(Student student) {
        //학번이 중복된다.
        if (repository.findById(student.getId()) != null) {
            throw new IllegalStateException("이미 존재하는 학번입니다.");
        }


    }
}
