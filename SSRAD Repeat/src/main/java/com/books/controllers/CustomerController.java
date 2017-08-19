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

import com.books.models.Customer;
import com.books.services.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;
    
    @RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
    @ResponseBody
    public Model getCustomers(Model m) {
    	List<Customer> customers = service.showCustomers();
    	m.addAttribute("customers", customers);
    	return m;
    }
    
    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    @ResponseBody
    public Model addCustomer(Model m) {
    	m.addAttribute("customer", new Customer());
    	return m;
    }
    
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ModelAndView addCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, RedirectAttributes redir, Model m){
    	if(result.hasErrors()){
    		// Due to cName having @NotBlank annotation, we can check if the input box was left empty as it will trigger an error. We then return the error message
    		if(result.getFieldError("cName") != null){
    			redir.addFlashAttribute("error", "may not be empty");
    		}

    		return new ModelAndView(new RedirectView("/addCustomer"));
    	}else{
    		service.addCustomer(customer);
    		return new ModelAndView(new RedirectView("/showCustomers"));
    	}
	}
}
