package iban.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import iban.springframework.spring5webapp.services.AuthorService;

@RestController
public class AuthorController {

	 private final AuthorService authorService;

	 
	

		public AuthorController(AuthorService authorService) {
	    	
	        this.authorService = authorService;
	    }

	    @GetMapping("/authors")
	    public String getAuthors(Model model) {

	        model.addAttribute("authors", authorService.findAll());

	        return "authors";
	    }
}
