package com.enigpusoop.controller;

import com.enigpusoop.service.BookService;

import java.util.Scanner;

public class App {
    BookService bookService = new BookService();
    Scanner input = new Scanner(System.in);
    Boolean isRun=true;

    public void run(){
        while (isRun){
            System.out.println("=========================\n" +
                    "Menu\n" +
                    "1. Tambah Buku\n" +
                    "2. Lihat Semua Buku\n" +
                    "3. Cari Buku\n" +
                    "4. Hapus Buku\n" +
                    "5. Exit\n");
            System.out.println("Masukan pilihan (1-5) :\t");
            int pilihan = input.nextInt();


            switch (pilihan){
                case 1:
                    bookService.add();
                    break;
                case 2:
                    bookService.getAll();
                    break;
                case 3:
                    bookService.searchByTitle();
                    break;
                case 4:
                    bookService.delete();
                    break;
            }
        }
    }
}
