package com.example.bookmanager.naver;

import com.example.bookmanager.naver.api.NaverBookSearchApi;
import com.example.bookmanager.naver.api.NaverBookSearchResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@WebAppConfiguration
@SpringBootTest
public class NaverBookSearchApiTest {
    @Autowired
    NaverBookSearchApi naverBookSearchApi;

    @Test
    public void testFindByIsbn() {
        System.out.println("====================");

        // given
        String isbn = "9791169253727";

        // when
        NaverBookSearchResponse rsp = naverBookSearchApi.findByIsbn(isbn);

        // then
        System.out.println(rsp);

        assertTrue(true);
        System.out.println("====================");
    }
}