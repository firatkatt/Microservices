package com.firatkat.libraryservice.dto;

import com.firatkat.libraryservice.model.Library;

public class LibraryDtoConvertor {
    public static LibraryDto convert(Library from){
        return LibraryDto.builder().id(from.getId()).build();
    }
}
