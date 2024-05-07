package com.example.bookmanager.naver;

import com.example.bookmanager.bookinfos.domain.BookInfo;
import com.example.bookmanager.naver.jpa.NaverBookInfoJpo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NaverBookInfoMapper {
    NaverBookInfoMapper INSTANCE = Mappers.getMapper(NaverBookInfoMapper.class);

    @Mapping(target = "id", ignore = true)
    NaverBookInfoJpo toNaverBookInfoJpo(NaverBookInfo naverBookInfo);
    @BeanMapping(ignoreUnmappedSourceProperties = "id")
    NaverBookInfo toNaverBookInfo(NaverBookInfoJpo naverBookInfoJpo);

    @Mapping(source = "pubdate", target = "publicationDate")
    @BeanMapping(ignoreUnmappedSourceProperties = {"link", "image", "discount"})
    BookInfo toBookInfo(NaverBookInfo naverBookInfo);
}
