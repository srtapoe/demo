package com.crudsimple.demo.repository;

import com.crudsimple.demo.entify.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
