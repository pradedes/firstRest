package com.mymaven.first.maven.api;

public interface Library {

	public Book find(int isbn) throws BookNotFoundException,LibraryException;

	public void add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException;

}