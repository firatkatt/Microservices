package com.firatkat.libraryservice.service;

import com.firatkat.libraryservice.client.BookServiceClient;

import com.firatkat.libraryservice.dto.AddBookRequest;
import com.firatkat.libraryservice.dto.LibraryDto;
import com.firatkat.libraryservice.dto.LibraryDtoConvertor;
import com.firatkat.libraryservice.exception.NotFoundLibraryException;
import com.firatkat.libraryservice.model.Library;
import com.firatkat.libraryservice.repository.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;
    public LibraryService(LibraryRepository libraryRepository,BookServiceClient bookServiceClient){
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }
    public LibraryDto getAllBooksInLibraryById(String id){
        Library library = libraryRepository.findById(id).orElseThrow(()->
                new NotFoundLibraryException("Library could not found by id"+id));
        LibraryDto libraryDto = LibraryDto.builder().id(library.getId()).bookDtos(library.
                getUserBook().stream().
                map(bookServiceClient::getBookById).map(ResponseEntity::getBody).collect(Collectors.toList())).build();
        return libraryDto;
    }
    public LibraryDto createLibrary(){
        Library newLibrary = libraryRepository.save(new Library());
        return LibraryDto.builder().id(newLibrary.getId()).build();
    }
    public void addBookToLibrary(AddBookRequest addBookRequest){
        String bookId = bookServiceClient.getBookByIsbn(addBookRequest.getIsbn()).getBody().getId();

        Library library = libraryRepository.findById(addBookRequest.getId()).
                orElseThrow(()->new NotFoundLibraryException("Library could not found by id"+addBookRequest.getId()));

        library.getUserBook().add(bookId);
        libraryRepository.save(library);
    }
}
