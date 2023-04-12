package com.jimin.bssm.hellospring.controller;

import com.jimin.bssm.hellospring.domain.Student;
import com.jimin.bssm.hellospring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students/new")
    public String createForm() {
        return "students/createStudentForm";
    }

    @PostMapping("/students/new")
    public String create(StudentForm form) {
        Student student = new Student();
        student.setId(form.getId());
        student.setName(form.getName());
        //학생 저장
        service.edit(student);
        return "redirect:/";
    }
}
