package com.example.book.event;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookCreated {
    private String id;
    private String title;
    private String author;
}
