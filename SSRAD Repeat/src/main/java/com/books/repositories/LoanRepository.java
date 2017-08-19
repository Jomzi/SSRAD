package com.books.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.models.Loan;

public interface LoanRepository extends CrudRepository<Loan, Long>{

}
