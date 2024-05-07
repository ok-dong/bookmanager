package com.example.bookmanager.naver;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NaverBookSearchApiSample {

    @Test
    public void search() {
        System.out.println("hello");

        WebClient webClient = WebClient
                .builder()
                .baseUrl("https://openapi.naver.com/v1/search/book.json")
                .defaultHeader("Host", "openapi.naver.com")
                .defaultHeader("Accept", "*/*")
                .defaultHeader("X-Naver-Client-Id", "IbpgUx8gm85S9X_6viO2")
                .defaultHeader("X-Naver-Client-Secret", "yfkarBd2PC")
                .build();

        WebClient.ResponseSpec retrieved = webClient.get().uri("?query=9791169253727").retrieve();
        String rsp = retrieved.bodyToMono(String.class).block();

        System.out.println(rsp);

        assertTrue(true);
    }

    @Test
    public void testFindByIsbn() {
        System.out.println("====================");

        // given
        String OPENAPI_NAVER_SEARCH_BOOK_JSON = "https://openapi.naver.com/v1/search/book.json";
        String isbn = "9791169253727";
        String clientId = "IbpgUx8gm85S9X_6viO2";
        String clientSecret = "yfkarBd2PC";

        // when
        WebClient webClient = WebClient
                .builder()
                .baseUrl(OPENAPI_NAVER_SEARCH_BOOK_JSON)
                .defaultHeader("Host", "openapi.naver.com")
                .defaultHeader("Accept", "*/*")
                .defaultHeader("X-Naver-Client-Id", clientId)
                .defaultHeader("X-Naver-Client-Secret", clientSecret)
                .build();

        WebClient.ResponseSpec retrieved = webClient.get().uri("?query=" + isbn).retrieve();
        String rsp = retrieved.bodyToMono(String.class).block();

        // then
        System.out.println(rsp);

        assertTrue(true);
        System.out.println("====================");
    }

    @Test
    public void searchDetail() {
        String endpoint = "https://openapi.naver.com/v1/search/book_adv.xml";

        WebClient webClient = WebClient
                .builder()
                .baseUrl(endpoint)
                .defaultHeader("Host", "openapi.naver.com")
                .defaultHeader("Accept", "*/*")
                .defaultHeader("X-Naver-Client-Id", "IbpgUx8gm85S9X_6viO2")
                .defaultHeader("X-Naver-Client-Secret", "yfkarBd2PC")
                .build();

        String param = "?d_titl=어린왕자&display=10&start=1";
//        String param = "?d_isbn=9791169253727&display=10&start=1";

        WebClient.ResponseSpec retrieved = webClient.get().uri(param).retrieve();
        String rsp = retrieved.bodyToMono(String.class).block();

        System.out.println("======================");
        System.out.println(rsp);
        System.out.println("======================");
        assertTrue(true);

    }

}