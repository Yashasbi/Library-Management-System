package com.example.Library.Management.System.output;

import com.example.Library.Management.System.model.BookCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class GetTotalBookForEachCategoryOutput {
    BookCategory bookCategory;
    int quantityOfBookAvailable;
}
