package com.example.graphqldemo.services;


import java.util.List;
import java.util.Optional;

import com.example.graphqldemo.models.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Book}.
 * 
 * @author <a href="mailto:softx.it@gmail.com">Mohammad Ali Azam</a>
 *
 */
public interface BookService {

	/**
	 * Save a book.
	 *
	 * @param book the entity to save.
	 * @return the persisted entity.
	 */
	Book save(Book book);

	/**
	 * Get all the books.
	 *
	 * @param pageable the pagination information.
	 * @return the list of entities.
	 */
	Page<Book> findAll(Pageable pageable);

	/**
	 * Get the "id" book.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<Book> findOne(Long id);

	/**
	 * Delete the "id" book.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);


	List<Book> findAll();

}