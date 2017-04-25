package com.mymaven.first.maven.data;

import com.mymaven.first.maven.api.Book;

public interface LibraryDAO {

	public void create(Book book);

	public Book read(int isbn);
}
