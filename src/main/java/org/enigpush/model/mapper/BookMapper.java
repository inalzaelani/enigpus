package org.enigpush.model.mapper;

import org.enigpush.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book(rs.getString("code"),
                rs.getString("title"),
                rs.getString("publisher"),
                rs.getString("publication_year"),
                rs.getString("author"));
        return book;
    }
}
