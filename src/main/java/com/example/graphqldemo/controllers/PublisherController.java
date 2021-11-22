package com.example.graphqldemo.controllers;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.graphqldemo.exceptions.ApiException;
import com.example.graphqldemo.models.Publisher;
import com.example.graphqldemo.services.PublisherService;

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
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @PostMapping("/publishers")
	public ResponseEntity<Publisher> createPublisher(@Valid @RequestBody Publisher publisher)
			throws URISyntaxException {
		log.debug("REST request to save Publisher : {}", publisher);
		if (publisher.getId() != null) {
			throw new URISyntaxException("A new Publisher must not have an ID",
					"PRIMARY KEY will be set by application");
		}

		try {
			Publisher result = publisherService.save(publisher);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}


    @PutMapping("/publishers")
	public ResponseEntity<Publisher> updatePublisher(@Valid @RequestBody Publisher publisher)
			throws URISyntaxException {
		log.debug("REST request to update Publisher : {}", publisher);
		if (publisher.getId() == null) {
			throw new ApiException("Publisher must have an ID to update",
					"PRIMARY KEY is required to udpate an entity");
		}

		try {
			Publisher result = publisherService.save(publisher);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

    @GetMapping("/publishers")
	public ResponseEntity<List<Publisher>> getAllPublishers(Pageable pageable) {
		log.debug("REST request to get a page of Publishers");
		Page<Publisher> page = publisherService.findAll(pageable);
		return ResponseEntity.ok().body(page.getContent());
	}


    @GetMapping("/publishers/{id}")
	public ResponseEntity<Publisher> getPublisher(@PathVariable Long id) {
		log.debug("REST request to get Publisher : {}", id);
		Optional<Publisher> publisher = publisherService.findOne(id);

		if (publisher.isPresent()) {
			return new ResponseEntity<>(publisher.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

    @DeleteMapping("/publishers/{id}")
	public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
		log.debug("REST request to delete Publisher : {}", id);

		try {
			publisherService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
