package org.enigpush.util;

import org.enigpush.model.Book;

public class Printer {
    public void printBook(Book book) {
        System.out.println("Code: " + book.getCode() + "\n" +
                    "Tittle: " + book.getTitle() + "\n" +
                    "Publisher: " + book.getPublisher() + "\n" +
                    "Publication Year: " + book.getPublicationyear() + "\n" +
                    "Author: " + book.getAuthor());
    }
}
