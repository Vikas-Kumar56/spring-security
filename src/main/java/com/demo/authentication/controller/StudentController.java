package com.demo.authentication.controller;

import com.demo.authentication.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENT = Arrays.asList(
            new Student(1, "vikas kumar"),
            new Student(2, "Amol kumar")
    );

    @GetMapping(path = "{studentId}")
    public ResponseEntity<Student> getStudents(@PathVariable("studentId") Integer studentId) {
        return STUDENT.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
