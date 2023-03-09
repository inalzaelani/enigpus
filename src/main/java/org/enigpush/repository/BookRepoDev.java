package org.enigpush.repository;

import org.enigpush.model.Book;
import org.enigpush.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepoDev implements IBookRepo{
    private ArrayList<Book> books = new ArrayList<>();
    private Printer printer;

    @Override
    public Book create(Book book) {
        this.books.add(book);
        System.out.println("Create success!");
        return book;
    }

    @Override
    public void createAll(List<Book> books) throws Exception {
        this.books.addAll(books);
        System.out.println("Bulk create success!");
    }

    @Override
    public List<Book> getall() {
        return this.books;
    }

    @Override
    public List<Book> searchByTitle(String title) {
        try {
         return this.books.stream().filter(name -> name.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
        }catch (Exception e){
            System.err.println("Book not found");
            return null;
        }
    }
    @Override
    public void delete() {
        int index = books.size() - 1;
        books.remove(index);
        System.out.println("Last Book Deleted...");
    }

}
