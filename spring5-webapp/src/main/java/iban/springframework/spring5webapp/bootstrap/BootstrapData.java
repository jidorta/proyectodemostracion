package iban.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import iban.springframework.spring5webapp.domain.Author;
import iban.springframework.spring5webapp.domain.Book;
import iban.springframework.spring5webapp.domain.Publisher;
import iban.springframework.spring5webapp.repositories.AuthorRepository;
import iban.springframework.spring5webapp.repositories.BookRepository;
import iban.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootstrapData  implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository  bookRepository;
	  private final PublisherRepository publisherRepository;
		
	

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
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
	        noEJB.setIsbn("54757585");

	        Author rodSaved = authorRepository.save(rod);
	        Book noEJBSaved = bookRepository.save(noEJB);

	        ericSaved.getBooks().add(dddSaved);
	        rodSaved.getBooks().add(noEJBSaved);

	        Publisher publisher = new Publisher();
	        publisher.setPublisherName("My Publisher");
	        publisher.setAddress("123 Main");
	        Publisher savedPublisher = publisherRepository.save(publisher);

	        dddSaved.setPublisher(savedPublisher);
	        noEJBSaved.setPublisher(savedPublisher);

	        authorRepository.save(ericSaved);
	        authorRepository.save(rodSaved);
	        bookRepository.save(dddSaved);
	        bookRepository.save(noEJBSaved);

	        System.out.println("In Bootstrap");
	        System.out.println("Author Count: " + authorRepository.count());
	        System.out.println("Book Count: " + bookRepository.count());



	        System.out.println("Publisher Count: " + publisherRepository.count());
		
	}
	
	

}
