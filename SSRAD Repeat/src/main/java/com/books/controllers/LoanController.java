package com.books.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.books.models.Customer;
import com.books.models.Loan;
import com.books.services.BookService;
import com.books.services.CustomerService;
import com.books.services.LoanService;

@RestController
public class LoanController {
	// Inject some services that we'll use here
	@Autowired
	private LoanService service;
	@Autowired
	private CustomerService custService;
	@Autowired
	private BookService bookService;
    
	// Fetch all loans and display them in a for loop on jsp page (using JSTL)
    @RequestMapping(value = "/showLoans", method = RequestMethod.GET)
    @ResponseBody
    public Model getLoans(Model m) {
    	List<Loan> loans = service.showLoans();
    	m.addAttribute("loans", loans);
    	return m;
    }
    
    @RequestMapping(value = "/newLoan", method = RequestMethod.GET)
    @ResponseBody
    public Model newLoan(Model m) {
    	m.addAttribute("loan", new Loan());
    	return m;
    }
    
    @RequestMapping(value = "/newLoan", method = RequestMethod.POST)
    public ModelAndView	newLoan(@ModelAttribute("loan") @Valid Loan loan, BindingResult result, RedirectAttributes redir, Model m){
    	boolean validLoan = true;
    	
    	// New Loan error checking happens here
		Book b = bookService.findBook(loan.getBook().getBid());
		Customer c = custService.findCustomer(loan.getCust().getcId());
		
		// Check if the book with bid exists
		if(b == null){
			// Add error message if it doesn't as flash attribute
			redir.addFlashAttribute("noSuchCust", "No such customer: " + loan.getCust().getcId());
			validLoan = false;
		}else{ // If it does check if it's already on loan (add error message if it is)
			List<Loan> loans = service.showLoans();
			for (Loan l: loans){
				if(l.getBook().getBid() == b.getBid()){
					validLoan = false;
					redir.addFlashAttribute("bookOnLoan", "Book: " + b.getBid() + " (" + b.getTitle() + ") already on loan to Customer: " + l.getCust().getcId() + " (" + l.getCust().getcName() + ")");
				}
			}
		}
		
		// Check if the customer with cid exists (Add error message if it doesn't)
		if(c == null){
			redir.addFlashAttribute("noSuchBook", "No such book: " + loan.getBook().getBid());
			validLoan = false;
		}
		
		// Set everything for the loan object and add it to the db
		if(validLoan){
			loan.setBook(b);
			loan.setCust(c);
			loan.setDueDate(newDueDate());
			service.newLoan(loan);
			
			return new ModelAndView(new RedirectView("/showLoans"));
		}else{
			return new ModelAndView(new RedirectView("/newLoan"));
		}
	}
    
    @RequestMapping(value = "/deleteLoan", method = RequestMethod.GET)
    @ResponseBody
    public Model deleteLoan(Model m) {
    	m.addAttribute("loan", new Loan());
    	return m;
    }
    
    @RequestMapping(value = "/deleteLoan", method = RequestMethod.POST)
    public ModelAndView	deleteLoan(@ModelAttribute("loan") @Valid Loan loan, BindingResult result, RedirectAttributes redir, Model m){
    	boolean deleted = service.deleteLoan(loan);
    	
    	// service.deleteLoan returns a boolean, true if loan exists(and deletes it) and false if it doesn't
		if(deleted){
			return new ModelAndView(new RedirectView("/showLoans"));
		}else{
			redir.addFlashAttribute("error", "No such Loan: " + loan.getLid());
			return new ModelAndView(new RedirectView("/deleteLoan"));
		}
	}
    
    // Method to create a dueDate that is 30 after today's date
    public String newDueDate(){
    	Calendar c = new GregorianCalendar();
		c.add(Calendar.DATE, 30);
		Date d = c.getTime();
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
		
		return ymd.format(d);
    }
}
