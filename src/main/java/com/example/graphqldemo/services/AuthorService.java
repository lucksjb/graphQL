package com.example.graphqldemo.services;

import java.util.Optional;

import com.example.graphqldemo.models.Author;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {

	/**
	 * Save a author.
	 *
	 * @param author the entity to save.
	 * @return the persisted entity.
	 */
	Author save(Author author);

	/**
	 * Get all the authors.
	 *
	 * @param pageable the pagination information.
	 * @return the list of entities.
	 */
	Page<Author> findAll(Pageable pageable);

	/**
	 * Get the "id" author.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<Author> findOne(Long id);

	/**
	 * Delete the "id" author.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}