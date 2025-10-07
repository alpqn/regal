package com.github.regal.models;

import jakarta.persistence.*;

import java.util.List;

/// Find a way to convert this to a record. [jakarta.persistence.GeneratedValue] requires id to be not-final
@Entity
public class Bookshelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<Long> books;

    protected Bookshelf() {}

    public Bookshelf(Long id, String name, List<Long> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Long> getBooks() {
        return books;
    }
}
