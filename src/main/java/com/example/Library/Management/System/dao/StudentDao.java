package com.example.Library.Management.System.dao;

import com.example.Library.Management.System.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository

public class StudentDao implements StudentInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    LibraryDao libraryDao;

    @Override
    public boolean issueBookToStudent(Student student) {

        if(libraryDao.isBookAvailable(student.getIsbnNumber()) && (isBookIssuedToStudent(student.getIsbnNumber(),student.getRollNumber()))){
            String query = String.format("Insert into studentinfo values('%s','%s','%s','%s','%s');",student.getRollNumber(),student.getIsbnNumber(),student.getBookCategory().toString(),student.getDateOfIssue(),student.getDateOfReturn());
            jdbcTemplate.execute(query);
            return true;
        }
        return false;

    }
    @Override
    public List<Student> getTotalActiveBook(UUID rollNumber){
        String query = String.format("Select * from studentinfo where studentid='%s';",rollNumber);
        List<Map<String, Object>> studentList = jdbcTemplate.queryForList(query);
        //System.out.println("The returned list of map is " +studentList);
        ArrayList<Student> listOfStudents = new ArrayList();
        if(studentList!=null){
            for(Map student : studentList) {
                System.out.println("The map is " +student);
                listOfStudents.add(objectMapper.convertValue(student,Student.class));
            }
        }
        return listOfStudents;
    }

    @Override
    public boolean isBookIssuedToStudent(UUID isbnNumber,UUID rollNumber) {
        String query = String.format("Select studentid from studentinfo where (bookid='%s' and studentid = '%s');",isbnNumber,rollNumber);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
        if(CollectionUtils.isEmpty(list)) {
            return true;
        }

        System.out.println("Book already issues");
        return false;
    }


}
