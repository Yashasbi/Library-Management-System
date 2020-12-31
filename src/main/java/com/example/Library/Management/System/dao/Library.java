package com.example.Library.Management.System.dao;

import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.BookCategory;
import com.example.Library.Management.System.model.Student;
import com.example.Library.Management.System.output.GetTotalBookForEachCategoryOutput;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Library {
     void addBookToDatabase(Book b);
     Optional<Book> findBookInDb(UUID bookId);
     List<Book> getTotalBookForEachCategory(BookCategory bookCategory);
     boolean updateBookQuantityInDb(UUID bookId);
     boolean isBookAvailable(UUID bookId);
}
