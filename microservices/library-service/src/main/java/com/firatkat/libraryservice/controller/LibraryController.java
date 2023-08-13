package com.firatkat.libraryservice.controller;

import com.firatkat.libraryservice.dto.AddBookRequest;
import com.firatkat.libraryservice.dto.LibraryDto;
import com.firatkat.libraryservice.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {
    private final LibraryService libraryService;
    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }
    @GetMapping
    public ResponseEntity<LibraryDto> getLibraryById(String id){
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
    }
    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(){
        return ResponseEntity.ok(libraryService.createLibrary());
    }
    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest addBookRequest){
        libraryService.addBookToLibrary(addBookRequest);
        return ResponseEntity.ok().build();
    }
}
