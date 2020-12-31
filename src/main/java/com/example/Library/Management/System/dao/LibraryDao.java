package com.example.Library.Management.System.dao;


import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.BookCategory;
import com.example.Library.Management.System.model.Student;
import com.example.Library.Management.System.output.GetTotalBookForEachCategoryOutput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Repository
public class LibraryDao implements Library{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void addBookToDatabase(Book book){
        String query = String.format("Insert into bookinfo values('%s','%s','%s','%s','%s',%s,%s);",
                book.getBookName(),book.getBookTitle(),book.getBookAuthor(),book.getBookCategory(),book.getIsbnNumber(),book.getTotalBookAvailable(),book.getTotalBookBooked());
        jdbcTemplate.execute(query);
    }

    @Override
    public Optional<Book> findBookInDb(UUID bookId) {
        String query = String.format("Select * from bookinfo where isbnnumber='%s'",bookId);
        List<Map<String, Object>> bookList = jdbcTemplate.queryForList(query);
        if(!CollectionUtils.isEmpty(bookList)) {
            return Optional.of(objectMapper.convertValue(bookList.get(0), Book.class));
        }
        return Optional.empty();
    }

    @Override
    public List<Book> getTotalBookForEachCategory(BookCategory bookCategory) {
        String query = String.format("Select * from bookinfo where bookcategory = '%s'",bookCategory.toString());
        List<Map<String,Object>> listOfBooks = jdbcTemplate.queryForList(query);
        ArrayList<Book> listOfBooksToReturn = new ArrayList<>();
        for(Map book : listOfBooks){
            listOfBooksToReturn.add(objectMapper.convertValue(book,Book.class));
        }
        return listOfBooksToReturn;
    }

    @Override
    public boolean updateBookQuantityInDb(UUID bookId) {
        String query = String.format("Update bookinfo set totalbookavailable = (totalbookavailable-1),totalbookbooked = (totalbookbooked +1) where isbnnumber = '%s'",bookId);
        jdbcTemplate.execute(query);
        return true;
    }

    @Override
    public boolean isBookAvailable(UUID bookId) {
        String query = String.format("Select totalbookavailable from bookinfo where isbnNumber = '%s' ",bookId);
        System.out.println("Hello");
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(query);
        int totalbookavailable=0;
        while(sqlRowSet.next()){
            totalbookavailable = sqlRowSet.getInt("totalbookavailable");
            //System.out.println(totalbookavailable);
        }
        return totalbookavailable > 0;
    }


}
