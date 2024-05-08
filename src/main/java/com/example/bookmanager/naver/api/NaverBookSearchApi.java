package com.example.bookmanager.naver.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class NaverBookSearchApi {
    @Value("${naver.api.search.book}")
    String NAVER_SEARCH_BOOK_JSON;
    @Value("${naver.api.client.id}")
    String clientId;
    @Value("${naver.api.client.secret}")
    String clientSecret;

    public NaverBookSearchResponse findByIsbn(String isbn) {


        WebClient webClient = WebClient
                .builder()
                .baseUrl(NAVER_SEARCH_BOOK_JSON)
                .defaultHeader("Host", "openapi.naver.com")
                .defaultHeader("Accept", "*/*")
                .defaultHeader("X-Naver-Client-Id", clientId)
                .defaultHeader("X-Naver-Client-Secret", clientSecret)
                .build();

        WebClient.ResponseSpec retrieved = webClient.get().uri("?query=" + isbn).retrieve();

        return retrieved.bodyToMono(NaverBookSearchResponse.class).block();
    }
}
