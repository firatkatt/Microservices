package com.firatkat.libraryservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;


import java.util.List;
@Getter
@Entity
public class Library {
    @Id
    @Column(name = "library_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    String id;
    @ElementCollection
    List<String> userBook;
}
