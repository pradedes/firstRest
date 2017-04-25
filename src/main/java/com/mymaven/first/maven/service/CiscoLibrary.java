package com.mymaven.first.maven.service;

import com.mymaven.first.maven.api.Book;
import com.mymaven.first.maven.api.BookNotFoundException;
import com.mymaven.first.maven.api.DuplicateBookException;
import com.mymaven.first.maven.api.InvalidBookException;
import com.mymaven.first.maven.api.Library;
import com.mymaven.first.maven.api.LibraryException;
import com.mymaven.first.maven.data.JPALibraryDAO;
import com.mymaven.first.maven.data.LibraryDAO;

public class CiscoLibrary implements Library {

	LibraryDAO dao = new JPALibraryDAO();
	
	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
			Book book = dao.read(isbn);
//			if(book == null){
//				throw new BookNotFoundException();
//			}
			return book;
	}

	@Override
	public void add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException {
		{
			if (book == null){
				throw new InvalidBookException();
			}
//			if (find(book.getIsbn()).equals(book)) {
//				throw new DuplicateBookException();
//			}
			dao.create(book);
		}
	}
}
