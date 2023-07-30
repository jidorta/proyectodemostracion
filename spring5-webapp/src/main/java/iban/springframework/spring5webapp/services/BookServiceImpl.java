package iban.springframework.spring5webapp.services;

import org.springframework.stereotype.Service;

import iban.springframework.spring5webapp.domain.Book;
import iban.springframework.spring5webapp.repositories.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
	
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}



	@Override
	public Iterable<Book> findAll() {

		return bookRepository.findAll();
	}

}
