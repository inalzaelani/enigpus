package com.enigpusoop.repository;

public interface IBookRepo {
    void add(String code, String title, String publisher,String publicationYear, String author);
    String getAll();
    String searchByTitle(String title);
    void delete(int index);
}
