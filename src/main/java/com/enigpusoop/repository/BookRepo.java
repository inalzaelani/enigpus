package com.enigpusoop.repository;

import com.enigpusoop.model.Book;

import java.util.*;


public class BookRepo implements IBookRepo{
    ArrayList<String[]> books = new ArrayList<>();
    @Override
    public void add(String code, String title, String publisher,String publicationYear, String author) {
        Book book = new Book();
        book.setBook(code, title, publisher, publicationYear, author);

        books.add(book.getBook());
    }

    @Override
    public String getAll() {
        String result ="";
        for(String[] book: books){
            result += "Code: " + book[0] +"\n" +
                    "Judul: " + book[1] +"\n" +
                    "Publisher: " + book[2] + "\n" +
                    "Tahun Terbit: " +book[3] + "\n" +
                    "Author: " +book[4]+"\n"+
                    "+++++++++++++++++++++++++++";
        }
        return result;
    }

    @Override
//    public String searchByTitle(String title) {
//        String result ="";
//        try {
//            for(String[] book : books) {
//                if (book[1].contains(title)) {
//                    result = "Code: " + book[0] + "\n" +
//                            "Judul: " + book[1] + "\n" +
//                            "Publisher: " + book[2] + "\n" +
//                            "Tahun Terbit: " + book[3] + "\n" +
//                            "Author: " + book[4] + "\n" +
//                            "+++++++++++++++++++++++++++";
//                }
//            }
//        }catch (Exception e){
//            System.err.println("Buku Tidak Ditemukan");
//        }
//
//        return result;
//    }
    public String searchByTitle(String title) {
        StringBuilder resultBuilder = new StringBuilder();
        boolean bookFound = false;
        try {
            for(String[] book : books) {
                if (book[1].contains(title)) {
                    resultBuilder.append("Code: " + book[0] + "\n" +
                            "Judul: " + book[1] + "\n" +
                            "Publisher: " + book[2] + "\n" +
                            "Tahun Terbit: " + book[3] + "\n" +
                            "Author: " + book[4] + "\n" +
                            "+++++++++++++++++++++++++++\n");
                    bookFound = true;
                }
            }
            if (!bookFound) {
                resultBuilder.append("Buku Tidak Ditemukan");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Indeks Array Salah");
        } catch (NullPointerException e) {
            System.err.println("Objek Null");
        }

        return resultBuilder.toString();
    }



    @Override
    public void delete(int index) {
        try{
            books.remove(index);
            System.out.println("Buku index ke-"+index+" dihapus!");
        }catch (Exception e){
            System.err.println("Index tidak ditemukan");
        }

    }
}
