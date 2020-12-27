package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.service.LibraryService;
import com.example.Library.Management.System.input.CreateBookingInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("api/v1/library")
@RestController

public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @PostMapping
    public String addBookToDatabase(@RequestBody CreateBookingInput createBookingInput){
        //System.out.println(libraryService.isCategoryValid(createBookingInput.getBookCategory()));
        if(libraryService.addBookToDatabase(createBookingInput)){
            return "Book added successfully to db";
        }
        else{
            return "Could not add book to db";
        }
    }
    @GetMapping
    public boolean findBookInDb(@RequestBody  String bookId){

        System.out.println("Inside library controller");
        String isbnNumber = bookId;
        System.out.println(isbnNumber);
        libraryService.findBookInDb(UUID.fromString(bookId));
        return true;
    }

}
