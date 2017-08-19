package com.books.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
