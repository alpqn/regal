package com.github.regal.models;

import jakarta.persistence.*;

/// Find a way to convert this to a record. [jakarta.persistence.GeneratedValue] requires id to be not-final
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private Genre genre;
    private Language language;

    protected Book() {}

    public Book(Long id, String title, String author, String publisher, Genre genre, Language language) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
