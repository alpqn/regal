package com.github.regal.controllers;

import com.github.regal.models.Bookshelf;
import com.github.regal.repositories.BookshelfRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/bookshelf")
public class BookshelfController {

    private final BookshelfRepository bookshelfRepository;

    public BookshelfController(BookshelfRepository bookshelfRepository) {
        this.bookshelfRepository = bookshelfRepository;
    }

    @GetMapping
    public List<Bookshelf> findAll() {
        return bookshelfRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bookshelf findById(@PathVariable Long id) {
        return bookshelfRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No such bookshelf"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Bookshelf shelf) {
        bookshelfRepository.save(shelf);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Bookshelf shelf, @PathVariable Long id) {
        bookshelfRepository.findById(shelf.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No such bookshelf"));
        var newShelf = new Bookshelf(
                id,
                shelf.getName(),
                shelf.getBooks()
        );

        bookshelfRepository.save(newShelf);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookshelfRepository.deleteById(id);
    }
}
