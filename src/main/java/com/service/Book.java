package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "book")
public class Book {


   private static String bookName;


    public static String getBookName() {
        return bookName;
    }

    @Value("${bookName}")
    public  void setBookName(String bookName) {
        Book.bookName = bookName;
    }
}
