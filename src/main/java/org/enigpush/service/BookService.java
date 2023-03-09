package org.enigpush.service;

import org.enigpush.model.Book;
import org.enigpush.repository.IBookRepo;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class BookService implements IBookService{
    private IBookRepo bookRepo;

    public BookService(IBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void createBook(Book book) {
        try {
            bookRepo.create(book);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void createAll(List<Book> books) throws Exception {
        try {
            bookRepo.createAll(books);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAllBook() {
        try {
            var allBook= bookRepo.getall();
            System.out.println("===== SEMUA BUKU =====");
            System.out.println(allBook);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Book> searchByTittleBook(String title) throws Exception {
        try{
            return bookRepo.searchByTitle(title);
        }catch (DataAccessException e){
            throw new Exception("Failed Get Book");
        }
    }

    @Override
    public void deleteBook() {
        try {
            this.bookRepo.delete();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
