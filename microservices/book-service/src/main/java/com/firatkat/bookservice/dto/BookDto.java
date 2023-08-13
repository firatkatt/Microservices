package com.firatkat.bookservice.dto;

import lombok.Builder;

@Builder
public class BookDto {
    BookIdDto id;
    String title;
    int year;
    String author;
    String pressName;
    String isbn;
}
