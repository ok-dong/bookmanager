package com.example.bookmanager.bookinfos.repository;

import com.example.bookmanager.bookinfos.domain.BookInfo;
import com.example.bookmanager.bookinfos.jpa.entity.BookInfoJpo;
import com.example.bookmanager.bookinfos.jpa.repository.BookInfoJpaRepository;
import com.example.bookmanager.naver.NaverBookInfoSearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class BookInfoRepository {
    private BookInfoJpaRepository bookInfoRepository;
    private NaverBookInfoSearchService naverBookInfoSearchService;

    public BookInfo findByIsbn(String isbn) {
        BookInfoJpo bookJpo = bookInfoRepository.findByIsbn(isbn);

        BookInfo bookInfo = BookInfoMapper.INSTANCE.toBookInfo(bookJpo);
//        BookInfo bookInfo = bookJpo.map(BookInfoMapper.INSTANCE::toBookInfo);

//        if (bookJpo.map(BookInfoMapper.INSTANCE::toBookInfo)) {
//            BookInfo bookInfo = naverBookInfoSearchService.findAndSaveByIsbn(isbn);
//            log.debug("bookInfo: {}", bookInfo);
//
//            BookInfoJpo newBookInfoJpo = BookInfoJpo.builder()
//                    .isbn(bookInfo.getIsbn())
//                    .author(bookInfo.getAuthor())
//                    .title(bookInfo.getTitle())
//                    .description(bookInfo.getDescription())
//                    .publicationDate(bookInfo.getPublicationDate())
//                    .publisher(bookInfo.getPublisher())
//                    .build();
//
//            log.debug("newBookJpo: {}", newBookInfoJpo);
//
//            BookInfoJpo saved = bookInfoRepository.saveAndFlush(newBookInfoJpo);
//            return BookInfoMapper.INSTANCE.toBookInfo(saved);
//        }

        return BookInfoMapper.INSTANCE.toBookInfo(bookJpo);
    }
}
