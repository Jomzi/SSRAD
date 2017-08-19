package com.books.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.models.Customer;
import com.books.repositories.CustomerRepository;

@Service("CustomerService")
public class CustomerService {
	@Autowired
	private CustomerRepository custRepo;
	
	public ArrayList<Customer> showCustomers(){
		return (ArrayList<Customer>) custRepo.findAll();
	}
	
	public Customer addCustomer(Customer c){
		return custRepo.save(c);
	}
	
	public Customer findCustomer(long id){
		return custRepo.findOne(id);
	}
}
