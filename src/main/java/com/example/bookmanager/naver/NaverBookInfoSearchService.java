package com.example.bookmanager.naver;

import com.example.bookmanager.bookinfos.domain.BookInfo;
import com.example.bookmanager.naver.api.NaverBookSearchApi;
import com.example.bookmanager.naver.api.NaverBookSearchResponse;
import com.example.bookmanager.naver.jpa.NaverBookInfoJpaRepository;
import com.example.bookmanager.naver.jpa.NaverBookInfoJpo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class NaverBookInfoSearchService {
    private NaverBookSearchApi api;
    private NaverBookInfoJpaRepository repository;

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public BookInfo findAndSaveByIsbn(String isbn) {
//        Optional<NaverBookInfoJpo> optJpo = repository.findByIsbn(isbn);
//
//        if (optJpo.isEmpty()) {
        if (!repository.existsByIsbn(isbn)) {
            NaverBookSearchResponse rsp = api.findByIsbn(isbn);
            NaverBookInfo naverBookInfo = rsp.getItems().get(0);
            log.debug("naverBookInfo: {}", naverBookInfo);

            NaverBookInfoJpo naverBookInfoJpo = NaverBookInfoMapper.INSTANCE.toNaverBookInfoJpo(naverBookInfo);
            log.debug("naverBookInfoJpo: {}", naverBookInfo);

            NaverBookInfoJpo saved = repository.saveAndFlush(naverBookInfoJpo);
            log.debug("saved: {}", saved);
        }

        Optional<NaverBookInfoJpo> optJpo = repository.findByIsbn(isbn);
        log.debug("found: {}", optJpo.get());
        NaverBookInfo naverBookInfo = NaverBookInfoMapper.INSTANCE.toNaverBookInfo(optJpo.get());
        log.debug("naverBookInfo: {}", naverBookInfo);

        return NaverBookInfoMapper.INSTANCE.toBookInfo(naverBookInfo);
    }
}
