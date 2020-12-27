package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dao.StudentDao;
import com.example.Library.Management.System.input.IssueBookToStudentInput;
import com.example.Library.Management.System.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component

public class StudentService {

    @Autowired
    StudentDao studentDao;

    public void issueBookToStudent(IssueBookToStudentInput issueBookToStudentInput){
        LocalDate dateofIssue = LocalDate.now();
        LocalDate dateOfReturn = LocalDate.now().plusDays(15);
        Student student = new Student(issueBookToStudentInput.getRollNumber(),issueBookToStudentInput.getIsbnNumber(),issueBookToStudentInput.getBookCategory().toString(),dateofIssue,dateOfReturn);
        studentDao.issueBookToStudent(student);
    }

}
