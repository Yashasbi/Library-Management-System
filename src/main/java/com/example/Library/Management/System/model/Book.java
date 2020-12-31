package com.example.Library.Management.System.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    @JsonAlias("bookname")
    private String bookName;
    @JsonAlias("booktitle")
    private String bookTitle;
    @JsonAlias("bookauthor")
    private String bookAuthor;
    @JsonAlias("bookcategory")
    private String bookCategory;
    @JsonAlias("isbnnumber")
    private UUID isbnNumber;
    @JsonAlias("totalbookavailable")
    private int totalBookAvailable;
    @JsonAlias("totalbookbooked")
    private int totalBookBooked;
}
