package com.example.bookmanager.bookshelves;

import com.example.bookmanager.books.BookService;
import com.example.bookmanager.books.domain.Book;
import com.example.bookmanager.bookshelves.domain.BookcaseJpo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BookcaseService {
    private BookcaseRepository repository;
    private BookService bookService;

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void add(Book book) {
        Book savedBook = bookService.create(book);

        BookcaseJpo jpo = BookcaseJpo.builder()
                .bookId(savedBook.getId())
                .ownerId("gwak.okdong@gmail.com")
                .build();

        BookcaseJpo bookShelvesJpo = repository.save(jpo);
    }

}
