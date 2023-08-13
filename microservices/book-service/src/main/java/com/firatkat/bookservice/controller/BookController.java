package com.firatkat.bookservice.controller;


import com.firatkat.bookservice.dto.BookDto;
import com.firatkat.bookservice.dto.BookIdDto;
import com.firatkat.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookservice){
        this.bookService = bookservice;
    }
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok((bookService.getAllBooks()));
    }
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotNull String isbn){
        return ResponseEntity.ok(bookService.getBookByIsbn(isbn));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotNull String id){
        return ResponseEntity.ok(bookService.findBookById(id));
    }
}
