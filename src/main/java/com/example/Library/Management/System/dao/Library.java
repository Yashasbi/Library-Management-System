package com.example.Library.Management.System.dao;

import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.Student;

import java.util.UUID;

public interface Library {
     void addBookToDatabase(Book b);
     boolean findBookInDb(UUID bookId);
}
