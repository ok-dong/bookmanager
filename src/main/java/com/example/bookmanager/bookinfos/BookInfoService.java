package com.example.bookmanager.bookinfos;

import com.example.bookmanager.bookinfos.domain.BookInfo;
import com.example.bookmanager.bookinfos.repository.BookInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BookInfoService {
    private BookInfoRepository bookInfoRepository;

    public BookInfo findByIsbn(String isbn) {
        return bookInfoRepository.findByIsbn(isbn);
    }
}
