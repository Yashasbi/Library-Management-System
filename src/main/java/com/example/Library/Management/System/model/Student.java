package com.example.Library.Management.System.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @JsonAlias("studentid")
    UUID rollNumber;
    @JsonAlias("bookid")
    UUID isbnNumber;
    @JsonAlias("bookcategory")
    String bookCategory;
    @JsonAlias("dateofissue")
    Timestamp dateOfIssue;
    @JsonAlias("dateofreturn")
    Timestamp dateOfReturn;
}
