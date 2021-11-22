package com.example.graphqldemo.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.graphqldemo.models.Book;
import com.example.graphqldemo.repositories.BookRepository;
import com.example.graphqldemo.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
  @Autowired
  private BookRepository bookRepository;

  @Override
  @Transactional
  public Book save(Book book) {
    log.debug("Request to save Book : {}", book);
    return bookRepository.save(book);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Book> findAll(Pageable pageable) {
    log.debug("Request to get all Books");
    return bookRepository.findAll(pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Book> findOne(Long id) {
    log.debug("Request to get Book : {}", id);
    return bookRepository.findById(id);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    log.debug("Request to delete Book : {}", id);
    bookRepository.deleteById(id);
  }

  @Override
  public List<Book> findAll() {
    log.debug("Request to find all books");
    return bookRepository.findAll();
  }

}
