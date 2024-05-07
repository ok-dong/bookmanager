package com.example.bookmanager.naver;

import com.example.bookmanager.bookinfos.domain.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@SpringBootTest
class NaverBookInfoSearchServiceTest {
    @Autowired
    NaverBookInfoSearchService service;

    @Test
    void findByIsbn() {
        // given
        String isbn = "9791169253727";

        // when
        BookInfo naverBookInfo = service.findAndSaveByIsbn(isbn);

        // then
        assertEquals(isbn, naverBookInfo.getIsbn());
        System.out.println(naverBookInfo);
    }
}