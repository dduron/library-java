package com.mongodb.library_java.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.library_java.schema.Book;
import com.mongodb.library_java.schema.Comment;
import com.mongodb.library_java.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> findOne(@PathVariable String id) {
        return bookService.findOne(id);
    }
    
    @PostMapping("/{id}/comment")
    public Optional<Book> addComment(@PathVariable String id, @RequestBody Comment comment) {
        return bookService.addComment(id, comment);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable String id) {
        bookService.remove(id);
    }
    
    @DeleteMapping("/removeAllComments/{id}")
    public void removeAllComments(@PathVariable String id) {
        bookService.removeAllComments(id);
    }
}
