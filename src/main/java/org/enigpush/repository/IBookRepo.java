package org.enigpush.repository;

import org.enigpush.model.Book;

import java.util.List;

public interface IBookRepo {
    public Book create(Book book) throws Exception;
    public void createAll(List<Book> books) throws Exception;
    public List<Book> getall() throws Exception;
    public List<Book> searchByTitle (String title) throws Exception;
    public void delete() throws Exception;
}

// public List<Buku> get(String name) {
//        List<Buku> names = new ArrayList<>();
//        for(var n : bukus){
//            if(n.getTitle().contains(name)){
//                names.add(n);
//            }
//        }
//        return names;
//    }
