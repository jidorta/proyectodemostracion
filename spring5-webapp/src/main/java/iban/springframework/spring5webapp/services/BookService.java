package iban.springframework.spring5webapp.services;

import iban.springframework.spring5webapp.domain.Book;

public interface BookService {
	
	Iterable<Book> findAll();

}
