package com.example.bookmanager.books.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Book {
    private Long id;
    private String isbn;

    private String title;
    private String author;
    private String description;

    private String publisher;
    private String publicationDate;
}
