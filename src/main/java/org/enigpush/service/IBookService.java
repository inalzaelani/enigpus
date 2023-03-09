package org.enigpush.service;

import org.enigpush.model.Book;

import java.util.ArrayList;
import java.util.List;

public interface IBookService {
    public void createBook(Book book);
    public void createAll(List<Book> books) throws Exception;
    public void getAllBook();
    public List<Book> searchByTittleBook(String title) throws Exception;
    public void deleteBook();
}

//    public void delete(int code) {
//        for(int i = 1; i<=bukus.size();i++){
//            if(get(code).getCode() == code){
//                bukus.remove(i);
//                System.out.println("Data deleted");
//                break;
//            }
//        }