package com.example.Library.Management.System.model;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.*;


@Getter
@Setter
@AllArgsConstructor

public class Book {

    private String bookName;
    private String bookTitle;
    private String bookAuthor;
    private String bookCategory;
    private UUID isbnNumber;
    private int totalBookAvailable;
    private int totalBookBooked;
}
