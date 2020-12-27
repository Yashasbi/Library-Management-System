package com.example.Library.Management.System.service;

import com.example.Library.Management.System.dao.LibraryDao;
import com.example.Library.Management.System.input.IssueBookToStudentInput;
import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.input.CreateBookingInput;
import com.example.Library.Management.System.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Component
public class LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    public boolean addBookToDatabase(CreateBookingInput createBookingInput) {
        UUID uuid = UUID.randomUUID();
        Book book = new Book(createBookingInput.getBookName(),createBookingInput.getBookTitle(),createBookingInput.getBookAuthor(),createBookingInput.getBookCategory().toString(),uuid,createBookingInput.getTotalBookAvailable(),createBookingInput.getTotalBookBooked());
        libraryDao.addBookToDatabase(book);
        return true;
    }

    public boolean findBookInDb(UUID bookId){
        System.out.println("Finding book in db");
        libraryDao.findBookInDb(bookId);
        return true;
    }
//    public boolean isCategoryValid(BookCategory category){
//        boolean isFound = Arrays.asList(BookCategory.values()).contains(category);
//        if(isFound){
//            return true;
//        }
//        return false;
//    }
//    public void issueBookToStudent(IssueBookToStudentInput issueBookToStudentInput) {
//        libraryDao.issueBookToStudent(student);
//    }
}
