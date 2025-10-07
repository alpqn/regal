package com.github.regal.repositories;

import com.github.regal.models.Bookshelf;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookshelfRepository extends ListCrudRepository<Bookshelf, Long> {
}
