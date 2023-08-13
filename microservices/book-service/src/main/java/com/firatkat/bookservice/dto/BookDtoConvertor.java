package com.firatkat.bookservice.dto;

import com.firatkat.bookservice.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDtoConvertor {
    public static List<BookDto> convert(List<Book> from) {
        return from.stream().map(i -> BookDto.builder().
                id(BookIdConvertor.convert(i)).
                title(i.getTitle()).
                year(i.getYear()).
                author(i.getAuthor()).
                pressName(i.getPressName()).
                isbn(i.getIsbn()).
                build()).
                collect(Collectors.toList());

    }

    public static BookDto convert(Book from) {
        return BookDto.builder()
                .id(BookIdConvertor.convert(from))
                .title(from.getTitle())
                .year(from.getYear())
                .author(from.getAuthor())
                .pressName(from.getPressName())
                .isbn(from.getIsbn())
                .build();

    }
}
