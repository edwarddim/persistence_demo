package com.example.persistencedemo.service;

import com.example.persistencedemo.mapper.BookMapper;
import com.example.persistencedemo.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<Book> findAll(String author) {
        return bookMapper.findAll(author);
    }

    public Book findById(long id) {
        return bookMapper.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Transactional
    public Book create(Book book) {
        bookMapper.insert(book);
        return book;
    }

    @Transactional
    public Book update(long id, Book book) {
        book.setId(id);
        if (bookMapper.update(book) == 0) {
            throw new BookNotFoundException(id);
        }
        return findById(id);
    }

    @Transactional
    public void delete(long id) {
        if (bookMapper.deleteById(id) == 0) {
            throw new BookNotFoundException(id);
        }
    }
}
