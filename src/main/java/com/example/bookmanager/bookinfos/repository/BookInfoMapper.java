package com.example.bookmanager.bookinfos.repository;

import com.example.bookmanager.bookinfos.domain.BookInfo;
import com.example.bookmanager.bookinfos.jpa.entity.BookInfoJpo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookInfoMapper {
    BookInfoMapper INSTANCE = Mappers.getMapper(BookInfoMapper.class);

    @Mapping(target = "id", ignore = true)
    BookInfoJpo toBookInfoJpo(BookInfo bookInfo);

    @BeanMapping(ignoreUnmappedSourceProperties = "id")
    BookInfo toBookInfo(BookInfoJpo bookInfoJpo);
}
