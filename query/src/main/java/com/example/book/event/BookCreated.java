package com.example.book.event;

import lombok.Data;

@Data
public class BookCreated {
    private String id;
    private String title;
    private String author;
}
