package com.example.bookmanager.books;

import com.example.bookmanager.books.domain.Book;
import com.example.bookmanager.books.entity.BookJpo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    @GetMapping()
    public List<BookJpo> list(Book bookInfo) {
        return bookService.findBooks();
    }

    @GetMapping("/{id}")
    public Book item(@PathVariable(name = "id") Long id) {
        return bookService.find(id);
    }

    @PostMapping()
    public Book create(@RequestBody Book bookInfo) {
        return bookService.create(bookInfo);
    }
}
