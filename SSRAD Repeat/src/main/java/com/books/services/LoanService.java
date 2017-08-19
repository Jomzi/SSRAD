package com.books.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.models.Loan;
import com.books.repositories.LoanRepository;

@Service("LoanService")
public class LoanService {
	@Autowired
	private LoanRepository loanRepo;
	
	public ArrayList<Loan> showLoans(){
		return (ArrayList<Loan>) loanRepo.findAll();
	}
	
	public Loan newLoan(Loan l){
		return loanRepo.save(l);
	}
	
	public boolean deleteLoan(Loan l){
		Loan temp = loanRepo.findOne(l.getLid());
		
		// Quick error check to see if loan with l.getLid() exists
		if(temp != null){
			loanRepo.delete(l.getLid());
			return true;
		}else{
			return false;
		}
	}
}
