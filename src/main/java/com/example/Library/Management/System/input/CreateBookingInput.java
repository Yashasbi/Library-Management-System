package com.example.Library.Management.System.input;

import com.example.Library.Management.System.model.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor

public class CreateBookingInput {
    private String bookName;
    private String bookTitle;
    private String bookAuthor;
    private BookCategory bookCategory;
    private UUID isbnNumber;
    private int totalBookAvailable;
    private int totalBookBooked;
    //System.out.println("Inside");
}
