package com.example.graphqldemo.services.impl;

import java.util.Optional;

import com.example.graphqldemo.models.Publisher;
import com.example.graphqldemo.repositories.PublisherRepository;
import com.example.graphqldemo.services.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PublisherImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    @Transactional
    public Publisher save(Publisher publisher) {
        log.debug("Request to save Publisher : {}", publisher);
		return publisherRepository.save(publisher);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Publisher> findAll(Pageable pageable) {
        log.debug("Request to get all Publishers");
		return publisherRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Publisher> findOne(Long id) {
        log.debug("Request to get Publisher : {}", id);
		return publisherRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Request to delete Publisher : {}", id);
		publisherRepository.deleteById(id);        
    }
    
}
