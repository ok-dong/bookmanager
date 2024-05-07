package com.example.bookmanager.books;

import com.example.bookmanager.books.domain.Book;
import com.example.bookmanager.books.entity.BookJpo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookJpo toBookJpo(Book book);

    Book toBook(BookJpo bookJpo);
}
