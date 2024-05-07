package com.example.bookmanager.bookinfos;

import com.example.bookmanager.bookinfos.domain.BookInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-info")
@AllArgsConstructor
public class BookInfoController {
    private BookInfoService bookInfoService;

    @GetMapping("/{isbn}")
    public BookInfo isbn(@PathVariable(name = "isbn") String isbn) {
        return bookInfoService.findByIsbn(isbn);
    }
}
