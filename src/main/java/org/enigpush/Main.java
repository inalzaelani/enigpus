package org.enigpush;

import org.enigpush.config.BeanConfigurationDev;
import org.enigpush.config.BeanConfigurationProd;
import org.enigpush.model.Book;
import org.enigpush.service.IBookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigurationDev.class, BeanConfigurationProd.class);
        IBookService bookService = ctx.getBean(IBookService.class);

        Book book = new Book("127","ASDFGHJ","ASD","2001","asd");
        bookService.createBook(book);

//        Book book2 = new Book("125","ASD","ASD","2001","asd");
//        Book book3 = new Book("126","ASD","ASD","2001","asd");
//        List<Book> books = new ArrayList<>();
//        books.add(book2);
//        books.add(book3);
//        try {
//            bookService.createAll(books);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//
        bookService.getAllBook();

//        try {
//            bookService.searchByTittleBook("ASDFGHJ");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//            bookService.deleteBook();
    }
}