package com.firatkat.bookservice.service;

import com.firatkat.bookservice.dto.BookDto;
import com.firatkat.bookservice.dto.BookDtoConvertor;

import com.firatkat.bookservice.dto.BookIdConvertor;
import com.firatkat.bookservice.dto.BookIdDto;
import com.firatkat.bookservice.exception.NotFoundBookException;
import com.firatkat.bookservice.model.Book;
import com.firatkat.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public List<BookDto> getAllBooks(){
        return BookDtoConvertor.convert(bookRepository.findAll());
    }
    public BookIdDto getBookByIsbn(String isbn){
        return bookRepository.findBookByIsbn(isbn).map(i-> BookIdConvertor.convert(i)).orElseThrow(() -> new NotFoundBookException("Book could not found by isbn"+isbn));
    }
    public BookDto findBookById(String id){
        return BookDtoConvertor.convert(bookRepository.findBookById(id).orElseThrow(()->new NotFoundBookException("Book could not fount by id"+id)));
    }

}
