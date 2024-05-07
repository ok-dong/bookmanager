package com.example.bookmanager.bookshelves;

import com.example.bookmanager.bookshelves.domain.BookcaseJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookcaseRepository extends JpaRepository<BookcaseJpo, Long> {
}
