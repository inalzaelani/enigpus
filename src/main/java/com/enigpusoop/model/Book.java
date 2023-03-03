package com.enigpusoop.model;

public class Book {
    private String code;
    private String title;
    private String publisher;
    private String publicationYear;
    private String author;




    public void setBook(String code, String title, String publisher,String publicationYear, String author) {
        this.code = code;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public String[] getBook(){
        String[] book = { this.code = code,this.title = title,this.publisher = publisher,this.publicationYear = publicationYear,this.author};
        return book;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationYear='" + publicationYear + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
