package com.example.bookmanager.bookinfos.jpa.repository;

import com.example.bookmanager.bookinfos.jpa.entity.BookInfoJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookInfoJpaRepository extends JpaRepository<BookInfoJpo, Long> {
    public Optional<BookInfoJpo> findByIsbn(String isbn);
}
