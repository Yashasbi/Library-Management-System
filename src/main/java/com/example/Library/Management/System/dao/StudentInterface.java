package com.example.Library.Management.System.dao;

import com.example.Library.Management.System.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentInterface {
     boolean issueBookToStudent(Student student);
     List<Student> getTotalActiveBook(UUID rollNumber);
     boolean isBookIssuedToStudent(UUID isbnNumber,UUID rollNumber);
}
