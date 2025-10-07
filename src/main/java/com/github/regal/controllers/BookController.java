package com.github.regal.controllers;

import com.github.regal.models.Book;
import com.github.regal.repositories.BookRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No such book"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Book book) {
        bookRepository.save(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Book book, @PathVariable Long id) {
        bookRepository.findById(book.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No such book"));
        var newBook = new Book(
            id,
            book.getTitle(),
            book.getAuthor(),
            book.getPublisher(),
            book.getGenre(),
            book.getLanguage()
        );
        bookRepository.save(newBook);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
