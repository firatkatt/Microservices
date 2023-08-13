package com.firatkat.bookservice.dto;

import com.firatkat.bookservice.model.Book;

public class BookIdConvertor {

    public static BookIdDto convert(Book book){
        return BookIdDto.builder().id(book.getId()).isbn(book.getIsbn()).build();
    }
}
