package iban.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import iban.springframework.spring5webapp.services.BookService;

@Controller
public class BookController {
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String getBook(Model model) {
		
		model.addAttribute("books", bookService.findAll());
		
		return "books";
	}

}
