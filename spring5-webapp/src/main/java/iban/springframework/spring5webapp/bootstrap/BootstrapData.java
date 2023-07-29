package iban.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import iban.springframework.spring5webapp.domain.Author;
import iban.springframework.spring5webapp.domain.Book;
import iban.springframework.spring5webapp.repositories.AuthorRepository;
import iban.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootstrapData  implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository  bookRepository;
		
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Author eric = new Author();
		
		eric.setFirstName("Eric");
		eric.setLastName("Evans");
		
		Book ddd = new Book();
		ddd.setTitle("Domain Driven Design");
		ddd.setIsbn("123456");
		
		
		Author ericSaved = authorRepository.save(eric);
		Book dddSaved = bookRepository.save(ddd);
		
		Author rod = new Author();
		rod.setFirstName("Rod");
		rod.setLastName("Johnson");
		
		Book noEJB = new Book();
		noEJB.setTitle("J2EE Development without EJB");
		noEJB.setIsbn("34535366");
		
		Author rodSaved = authorRepository.save(rod);
		Book noEJBSaved = bookRepository.save(noEJB);
		
		ericSaved.getBooks().add(dddSaved);
		rodSaved.getBooks().add(noEJBSaved);
		
		System.out.println("In Bootstrap");
		System.out.println("Author Count: " + authorRepository.count());
		System.out.println("Book Count: " +   bookRepository.count());
		
		
	}
	
	

}
