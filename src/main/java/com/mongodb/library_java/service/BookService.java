package com.mongodb.library_java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.library_java.schema.Book;
import com.mongodb.library_java.schema.Comment;
import com.mongodb.library_java.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findOne(String id) {
        return bookRepository.findById(id);
    }

    public Book create(Book book) {
        return bookRepository.insert(book);
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> addComment(String id, Comment comment) {
        Optional<Book> findBook = bookRepository.findById(id);
        if(findBook.isPresent()) {
            Book updateBook = findBook.get();
            if(updateBook.getComments() == null) {
                updateBook.setComments(new ArrayList<Comment>());
                updateBook.getComments().add(comment);
            } else {
                updateBook.getComments().add(comment);
            }         
            bookRepository.save(updateBook);
        }
        return bookRepository.findById(id);
    }

    public void remove(String id) {
        bookRepository.deleteById(id);
    }

    public void removeAllComments(String id) {
        bookRepository.removeAllComments(id);
    }
}
