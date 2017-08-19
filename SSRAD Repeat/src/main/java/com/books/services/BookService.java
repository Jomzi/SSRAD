package com.books.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.models.Book;
import com.books.repositories.BookRepository;

@Service("BookService")
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public ArrayList<Book> showBooks(){
		return (ArrayList<Book>) bookRepo.findAll();
	}
	
	public Book addBook(Book b){
		return bookRepo.save(b);
	}
	
	public Book findBook(long id){
		return bookRepo.findOne(id);
	}
}
