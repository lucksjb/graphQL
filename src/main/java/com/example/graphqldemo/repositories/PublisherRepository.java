package com.example.graphqldemo.repositories;

import com.example.graphqldemo.models.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    
}
