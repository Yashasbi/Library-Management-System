package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.input.FindBookInput;
import com.example.Library.Management.System.input.GetTotalActiveBookInput;
import com.example.Library.Management.System.input.GetTotalBookForEachCategoryInput;
import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.Student;
import com.example.Library.Management.System.output.GetTotalBookForEachCategoryOutput;
import com.example.Library.Management.System.service.LibraryService;
import com.example.Library.Management.System.input.CreateBookingInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("api/v1/library")
@RestController

public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @PostMapping
    public String addBook(@RequestBody CreateBookingInput createBookingInput) {
        //System.out.println(libraryService.isCategoryValid(createBookingInput.getBookCategory()));
        if(libraryService.addBookToDatabase(createBookingInput)){
            return "Book added successfully to db";
        }
        else{
            return "Could not add book to db";
        }
    }
    @GetMapping
    public Book findBook(@RequestBody FindBookInput input){
        //System.out.println(input.getBookId());
        Optional<Book> book = libraryService.findBookInDb(input.getBookId());
        if(book.isPresent()) {
            return book.get();
        }
        throw new InputMismatchException(String.format("BookId %s is not a valid bookId", input.getBookId()));
    }

    @RequestMapping(value = "/getTotalActiveBook", method = GET)
    public List<Student> getTotalActiveBook(@RequestBody  GetTotalActiveBookInput getTotalActiveBookInput){
        //System.out.println("Studentid is " +getTotalActiveBookInput.getRollNumber());
        return(libraryService.getTotalActiveBook(getTotalActiveBookInput.getRollNumber()));
    }

    @RequestMapping(value = "/getTotalBookForEachCategory" ,method = GET)
    public List<Book> getTotalBookForEachCategory(@RequestBody GetTotalBookForEachCategoryInput getTotalBookForEachCategory){
        //System.out.println("The category for the input is " +getTotalBookForEachCategory.getBookCategory());
        return libraryService.getTotalBookForEachCategory(getTotalBookForEachCategory.getBookCategory());
    }

}
