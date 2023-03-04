package com.enigpusoop.service;

import com.enigpusoop.repository.BookRepo;

import java.util.Scanner;

public class BookService implements IBookService{
    BookRepo bookRepo = new BookRepo();
    Scanner input = new Scanner(System.in);

    protected String code;
    protected String title;
    protected String publisher;
    protected String publicationYear;
    protected String author;


    @Override
    public void add() {
        while(true){
            System.out.println("===TAMBAH BUKU=====");
            System.out.print("Masukan Kode Buku :\t");
            String code = input.nextLine();

            if(code.length()<1){
                System.out.println("Kode Tidak Boleh Kosong");
            }else {
                this.code = code;
                break;
            }
        }
        while(true){
            System.out.print("Masukan judul Buku :\t");
            String title = input.nextLine();

            if(title.length()<1){
                System.out.println("Judul Tidak Boleh Kosong");
            }else {
                this.title = title;
                break;
            }
        }
        while(true){
            System.out.print("Masukan publisher Buku :\t");
            String publisher = input.nextLine();

            if(publisher.length()<1){
                System.out.println("publisher Tidak Boleh Kosong");
            }else {
                this.publisher = publisher;
                break;
            }
        }
        while(true){
            System.out.print("Masukan tahun publikasi Buku :\t");
            String publicationYear = input.nextLine();

            if(publicationYear.length()<1){
                System.out.println("tahun publikasi Tidak Boleh Kosong");
            }else {
                this.publicationYear = publicationYear;
                break;
            }
        }

        while(true){
            System.out.print("Masukan Author Buku :\t");
            String author = input.nextLine();

            if(author.length()<1){
                System.out.println("tahun publikasi Tidak Boleh Kosong");
            }else {
                this.author = author;
                break;
            }
        }
        bookRepo.add(this.code,this.title,this.publisher,this.publicationYear,this.author);


    }

    @Override
    public void getAll() {
        String allBook= bookRepo.getAll();
        System.out.println("+++ SEMUA BUKU +++");
        System.out.println(allBook);
    }

    @Override
    public void searchByTitle() {
        System.out.println("Masukan Judul Buku :");
        String title = input.nextLine();
        bookRepo.searchByTitle(title);
    }

    @Override
    public void delete() {
        System.out.println("Masukan index :");
        int index = input.nextInt();
        bookRepo.delete(index);

    }
}
