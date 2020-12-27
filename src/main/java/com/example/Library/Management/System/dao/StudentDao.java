package com.example.Library.Management.System.dao;

import com.example.Library.Management.System.model.BookCategory;
import com.example.Library.Management.System.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository

public class StudentDao implements StudentInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void issueBookToStudent(Student student) {
        String query = String.format("Insert into studentinfo values('%s','%s','%s','%s','%s');",student.getRollNumber(),student.getIsbnNumber(),student.getBookCategory().toString(),student.getDateOfIssue(),student.getDateOfReturn());
        jdbcTemplate.execute(query);
    }


}
