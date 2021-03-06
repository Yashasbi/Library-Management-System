package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.input.IssueBookToStudentInput;
import com.example.Library.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/student")
@RestController

public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public void issueBookToStudent(@RequestBody IssueBookToStudentInput issueBookToStudentInput) {
        studentService.issueBookToStudent(issueBookToStudentInput);
    }
}
