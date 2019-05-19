package com.example.book.event;

import lombok.Data;

@Data
public class BookEdited {
    private String id;
    private String title;
    private String author;
}
