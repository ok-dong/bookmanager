package com.example.bookmanager.books.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BookJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;

//    private String title;
//    private String author;
//    @Lob
//    private String description;
//
//    private String publisher;
//    private String publicationDate;
    private Long bookcaseId;
    private String ownerId;

}
