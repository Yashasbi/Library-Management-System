package com.example.Library.Management.System.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    UUID rollNumber;
    UUID isbnNumber;
    String bookCategory;
    LocalDate dateOfIssue;
    LocalDate dateOfReturn;
}
