package com.example.bookmanager.bookshelves;

import com.example.bookmanager.books.domain.Book;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookcase")
@AllArgsConstructor
public class BookcaseController {
    private BookcaseService service;

//    @GetMapping("/{id}")
//    public Bookshelves find(@PathVariable(name = "id") Long id) {
//
//    }

    @PostMapping
    public void add(@RequestBody Book book) {
        service.add(book);
    }
}
