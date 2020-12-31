package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dao.LibraryDao;
import com.example.Library.Management.System.dao.StudentDao;
import com.example.Library.Management.System.input.IssueBookToStudentInput;
import com.example.Library.Management.System.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Component

public class StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    LibraryDao libraryDao;

    public boolean issueBookToStudent(IssueBookToStudentInput issueBookToStudentInput){
        LocalDateTime localDateTimeIssue = LocalDateTime.now();
        LocalDateTime localDateOfReturn = LocalDateTime.now().plusDays(15);
        Timestamp dateOfIssue = Timestamp.valueOf(localDateTimeIssue);
        Timestamp dateOfReturn = Timestamp.valueOf(localDateOfReturn);

        Student student = new Student(issueBookToStudentInput.getRollNumber(),issueBookToStudentInput.getIsbnNumber(),issueBookToStudentInput.getBookCategory().toString(),dateOfIssue,dateOfReturn);
        if(studentDao.issueBookToStudent(student)){
            libraryDao.updateBookQuantityInDb(student.getIsbnNumber());
            return true;
        }
        return false;
    }


}
