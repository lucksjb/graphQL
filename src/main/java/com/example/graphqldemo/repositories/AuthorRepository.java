package com.example.graphqldemo.repositories;

import com.example.graphqldemo.models.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
