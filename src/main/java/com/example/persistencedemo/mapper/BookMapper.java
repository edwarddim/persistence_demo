package com.example.persistencedemo.mapper;

import com.example.persistencedemo.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * MyBatis mapper. SQL lives in src/main/resources/mapper/BookMapper.xml.
 */
@Mapper
public interface BookMapper {

    List<Book> findAll(@Param("author") String author);

    Optional<Book> findById(@Param("id") long id);

    int insert(Book book);

    int update(Book book);

    int deleteById(@Param("id") long id);
}
