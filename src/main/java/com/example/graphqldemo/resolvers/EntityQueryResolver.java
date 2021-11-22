package com.example.graphqldemo.resolvers;

import java.util.List;
import java.util.Optional;

import com.example.graphqldemo.models.Author;
import com.example.graphqldemo.models.Book;
import com.example.graphqldemo.models.Publisher;
import com.example.graphqldemo.services.AuthorService;
import com.example.graphqldemo.services.BookService;
import com.example.graphqldemo.services.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class EntityQueryResolver implements GraphQLQueryResolver  {
    @Autowired
    private PublisherService publisherService;
    @Autowired
	private AuthorService authorService;
    @Autowired
	private BookService bookService;


    public Publisher getPublisherById(Long id) {
		try {
			Optional<Publisher> publisher = publisherService.findOne(id);
			if (publisher.isPresent()) {
				return publisher.get();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


    public Author getAuthorById(Long id) {
		try {
			Optional<Author> author = authorService.findOne(id);
			if (author.isPresent()) {
				author.get().getBooks();
				return author.get();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

    public Book getBookById(Long id) {
		try {
			Optional<Book> book = bookService.findOne(id);
			if (book.isPresent()) {
				return book.get();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Book> getBooks() {
		return bookService.findAll();
	}
}
