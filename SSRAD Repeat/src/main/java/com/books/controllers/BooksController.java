package com.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.books.models.Book;
import com.books.services.BookService;

@RestController
public class BooksController {
	@Autowired
	private BookService service;
    
    @RequestMapping(value = "/showBooks", method = RequestMethod.GET)
    @ResponseBody
    public Model getBooks(Model m) {
    	List<Book> books = service.showBooks();
    	m.addAttribute("books", books);
    	return m;
    }
    
    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    @ResponseBody
    public Model addBook(Model m) {
    	m.addAttribute("book", new Book());
    	return m;
    }
    
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute("book") @Valid Book book, BindingResult result, RedirectAttributes redir, Model m){
    	// Errors get triggered on these inputs because the book model states that title and author can not be null
    	if(result.hasErrors()){
    		if(result.getFieldError("title") != null){
    			// Add a flash attribute to the redirect to display error message
    			redir.addFlashAttribute("errorTitle", "may not be empty");
    		}
    		
    		if (result.getFieldError("author") != null){
    			redir.addFlashAttribute("errorAuthor", "may not be empty");
    		}

    		return new ModelAndView(new RedirectView("/addBook"));
    	}else{
    		service.addBook(book);
    		return new ModelAndView(new RedirectView("/showBooks"));
    	}
	}
}
