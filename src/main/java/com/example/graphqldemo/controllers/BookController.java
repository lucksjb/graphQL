package com.example.graphqldemo.controllers;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.graphqldemo.exceptions.ApiException;
import com.example.graphqldemo.models.Book;
import com.example.graphqldemo.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class BookController {
    @Autowired
    private  BookService bookService; 

    @PostMapping("/books")
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) throws URISyntaxException {
		log.debug("REST request to save Book : {}", book);

		try {
			if (book.getId() != null) {
				throw new ApiException("A new book cannot already have an ID id exists",
						"PRIMARY KEY will be set by application");
			}
			Book result = bookService.save(book);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

	}

    @PutMapping("/books")
	public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book) throws URISyntaxException {
		log.debug("REST request to update Book : {}", book);

		try {
			if (book.getId() == null) {
				throw new ApiException("A book must have an ID to update",
						"PRIMARY KEY is required to udpate an entity");
			}
			Book result = bookService.save(book);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

	}

    @GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(Pageable pageable) {
		log.debug("REST request to get a page of Books");
		Page<Book> page = bookService.findAll(pageable);
		return ResponseEntity.ok().body(page.getContent());
	}

    @GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
		log.debug("REST request to get Book : {}", id);
		Optional<Book> book = bookService.findOne(id);
		if (book.isPresent()) {
			return new ResponseEntity<>(book.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	    
    @DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		log.debug("REST request to delete Book : {}", id);

		try {
			bookService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
