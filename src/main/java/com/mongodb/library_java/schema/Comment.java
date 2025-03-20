package com.mongodb.library_java.schema;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Comment {

    private String id;

    private String title;

    private int stars;

    private String comment;

    @DBRef
    private List<User> username;
}