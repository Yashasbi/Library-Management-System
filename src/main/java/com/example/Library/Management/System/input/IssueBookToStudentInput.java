package com.example.Library.Management.System.input;

import com.example.Library.Management.System.model.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor

public class IssueBookToStudentInput {
    UUID rollNumber;
    UUID isbnNumber;
    BookCategory bookCategory;
}
