package org.enigpush.repository;

import org.enigpush.model.Book;
import org.enigpush.model.mapper.BookMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookRepo implements IBookRepo{

    private JdbcTemplate jdbcTemplate;

    private final String SQL_CREATE_BOOK = "insert into book (code,title,publisher,publication_year,author) values (?,?,?,?,?)";
    private final String SQL_GET_ALL = "select * from book";
    private final String SQL_FIND_BY_TITLE = "select * from book where title =?";
    private final String SQL_DELETE_BOOK = "DELETE FROM book WHERE id = (SELECT MAX(id) FROM book)";


    public BookRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public BookRepo() {
    }

    @Override
    public Book create(Book book) throws Exception{
        try{
            int result = jdbcTemplate.update(SQL_CREATE_BOOK, book.getCode(),book.getTitle(),book.getPublisher(),book.getPublicationyear(),book.getAuthor());
            System.out.println("Create success!");
            if(result<= 0){
                throw  new Exception("Failed Insert Course");
            }
            return book;
        }catch (DataAccessException e){
            throw new RuntimeException();
        }

    }
    public void createAll(List<Book> books) throws Exception {
        try {
            jdbcTemplate.batchUpdate(SQL_CREATE_BOOK, new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Book book = books.get(i);
                    ps.setString(1, book.getCode());
                    ps.setString(2, book.getTitle());
                    ps.setString(3, book.getPublisher());
                    ps.setString(4, book.getPublicationyear());
                    ps.setString(5, book.getAuthor());
                }
                public int getBatchSize() {
                    return books.size();
                }
            });
            System.out.println("Bulk create success!");
        } catch (DataAccessException e) {
            throw new Exception("Failed to insert books: " + e.getMessage());
        }
    }


    @Override
    public List<Book> getall() throws Exception {
        try {
            return jdbcTemplate.query(SQL_GET_ALL, new BookMapper());
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Book> searchByTitle(String title) throws Exception {
        try {
            List<Book> books = jdbcTemplate.query(SQL_FIND_BY_TITLE, new BookMapper(), title);
            books.forEach(System.out::println);
            return books;
        } catch (DataAccessException e) {
            System.err.println("Book not found");
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public void delete() throws Exception{
        try{
            jdbcTemplate.update(SQL_DELETE_BOOK);
            System.out.println("Last Book Deleted...");
        }catch (DataAccessException e){
            throw  new Exception("Failed to delete course");
        }
    }
}
