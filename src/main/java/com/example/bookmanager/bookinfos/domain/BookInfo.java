package com.example.bookmanager.bookinfos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BookInfo {
    private String isbn;

    private String title;
    private String author;
    private String description;

    private String publisher;
    private String publicationDate;
}
