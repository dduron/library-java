package com.mongodb.library_java.schema;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "books")
public class Book {
    @Id
    private String id;

    private String title;

    private String genre;

    private String description;

    private String author;

    private int pages;

    private String image_url;

    private List<String> keywords;

    private List<Comment> comments;
}
