package iban.springframework.spring5webapp.services;

import org.springframework.stereotype.Service;

import iban.springframework.spring5webapp.domain.Author;
import iban.springframework.spring5webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl {
	  private final AuthorRepository authorRepository;

	    public AuthorServiceImpl(AuthorRepository authorRepository) {
	        this.authorRepository = authorRepository;
	    }

	    public Iterable<Author> findAll() {
	        return authorRepository.findAll();
	    }
}
