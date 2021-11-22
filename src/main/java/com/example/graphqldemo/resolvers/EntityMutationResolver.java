package com.example.graphqldemo.resolvers;

import com.example.graphqldemo.models.Author;
import com.example.graphqldemo.models.Book;
import com.example.graphqldemo.models.Publisher;
import com.example.graphqldemo.services.AuthorService;
import com.example.graphqldemo.services.BookService;
import com.example.graphqldemo.services.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class EntityMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private PublisherService publisherService;
    @Autowired
	private AuthorService authorService;
    @Autowired
	private BookService bookService;

    public Publisher addPublisher(String name) throws Exception {
		Publisher publisher = new Publisher();
        publisher.setName(name);
		return publisherService.save(publisher);
	}

    public Author addAuthor(String name) throws Exception {
		Author author = new Author();
        author.setName(name);
		return authorService.save(author);
	}

    public Book addBook(String title, String ISBN, Long publisherId, Long authorId) throws Exception {
		Book book = new Book();
        book.setISBN(ISBN);
		book.setAuthor(authorService.findOne(authorId).get());
		book.setPublisher(publisherService.findOne(publisherId).get());
		return bookService.save(book);

	}
}
