package iban.springframework.spring5webapp.services;

import iban.springframework.spring5webapp.domain.Author;

public interface AuthorService {
	 Iterable<Author> findAll();
}
