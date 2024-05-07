package com.example.bookmanager.books.repository;

import com.example.bookmanager.books.entity.BookJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookJpo, Long> {
    public Optional<BookJpo> findByIsbn(String isbn);
}
