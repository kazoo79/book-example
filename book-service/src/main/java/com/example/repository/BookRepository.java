package com.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.repository.resource.Book;

/**
 * Created by pdebala on 2016-10-07.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
