package com.example.Library.Management.System.dao;


import com.example.Library.Management.System.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class LibraryDao implements Library{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBookToDatabase(Book book){
        String query = String.format("Insert into bookinfo values('%s','%s','%s','%s','%s',%s,%s);",
                book.getBookName(),book.getBookTitle(),book.getBookAuthor(),book.getBookCategory(),book.getIsbnNumber(),book.getTotalBookAvailable(),book.getTotalBookBooked());
        jdbcTemplate.execute(query);
    }

    @Override
    public boolean findBookInDb(UUID bookId) {
        String query = String.format("Select isbnnumber from bookinfo where isbnnumber='%s'",bookId);
        List<Map<String, Object>> isbnNumber = jdbcTemplate.queryForList(query);
        System.out.println(isbnNumber);
        return true;
    }
}
