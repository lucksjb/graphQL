package com.example.graphqldemo.services.impl;

import java.util.Optional;

import com.example.graphqldemo.models.Author;
import com.example.graphqldemo.repositories.AuthorRepository;
import com.example.graphqldemo.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional
    public Author save(Author author) {
        log.debug("Request to save Author : {}", author);
		return authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Author> findAll(Pageable pageable) {
        log.debug("Request to get all Authors");
		return authorRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findOne(Long id) {
        log.debug("Request to get Author : {}", id);
		return authorRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Request to delete Author : {}", id);
		authorRepository.deleteById(id);
    }
    
}
