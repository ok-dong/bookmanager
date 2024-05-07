package com.example.bookmanager.naver.api;

import com.example.bookmanager.naver.NaverBookInfo;
import lombok.Data;

import java.util.List;

@Data
public class NaverBookSearchResponse {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<NaverBookInfo> items;
}
