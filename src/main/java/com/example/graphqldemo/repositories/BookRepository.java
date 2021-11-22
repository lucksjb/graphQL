package com.example.graphqldemo.repositories;

import com.example.graphqldemo.models.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    
}
