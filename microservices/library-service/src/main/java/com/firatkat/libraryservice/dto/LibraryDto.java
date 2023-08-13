package com.firatkat.libraryservice.dto;

import lombok.Builder;


import java.util.List;

@Builder
public class LibraryDto {
    String id;
    List<BookDto> bookDtos;

}
