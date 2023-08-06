package iban.springframework.spring5webapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import iban.springframework.spring5webapp.services.BookService;

@Controller
public class BookController {
	
	private final BookService bookService;

	public BookController(BookService bookService) {

		this.bookService = bookService;
		
	}
	
    @GetMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookService.findAll());

        return "books";
    }

}
