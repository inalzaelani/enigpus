package org.enigpush.model;

public class Book {
    private String code;
    private String title;
    private String publisher;
    private String publicationyear;
    private String author;


    public Book() {
    }

    public Book(String code, String title, String publisher, String publicationyear, String author) {
        this.code = code;
        this.title = title;
        this.publisher = publisher;
        this.publicationyear = publicationyear;
        this.author = author;
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

    public String getPublicationyear() {
        return publicationyear;
    }

    public void setPublicationyear(String publicationyear) {
        this.publicationyear = publicationyear;
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
                ", publicationyear='" + publicationyear + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
