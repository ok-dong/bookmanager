package com.example.bookmanager.books;

import com.example.bookmanager.books.domain.Book;
import com.example.bookmanager.books.entity.BookJpo;
import com.example.bookmanager.books.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BookService {
    private BookRepository bookRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public Book create(Book book) {
        BookJpo entityBookInfoJpo = BookMapper.INSTANCE.toBookJpo(book);
        BookJpo savedBookInfoJpo = bookRepository.saveAndFlush(entityBookInfoJpo);

        return BookMapper.INSTANCE.toBook(savedBookInfoJpo);
    }

    public Book find(Long id) {
        Optional<BookJpo> book = bookRepository.findById(id);

        if (book.isPresent()) {
            return BookMapper.INSTANCE.toBook(book.get());
        } else {
            return null;
        }
    }

    public List<BookJpo> findBooks() {
        return bookRepository.findAll();
    }
}
