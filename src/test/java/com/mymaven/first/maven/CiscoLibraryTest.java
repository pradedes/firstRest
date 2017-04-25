package com.mymaven.first.maven;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mymaven.first.maven.api.Author;
import com.mymaven.first.maven.api.Book;
import com.mymaven.first.maven.api.BookNotFoundException;
import com.mymaven.first.maven.api.InvalidBookException;
import com.mymaven.first.maven.api.LibraryException;
import com.mymaven.first.maven.service.CiscoLibrary;

import junit.framework.TestCase;

public class CiscoLibraryTest extends TestCase {

	@Test
	public void testadd() {
		Book bk = new Book();
		bk.setIsbn(12323);
		bk.setTitle("BookEx90ampfsd");
		Author a1 = new Author();
		a1.setName("abc");
		
		Author a2 = new Author();
		a2.setName("rty");
		
		Author a3 = new Author();
		a3.setName("adsjgbc");
		
		List l1 = new ArrayList<>();
		l1.add(a1);
		l1.add(a2);
		l1.add(a3);
		bk.setAuthors(l1);

		CiscoLibrary lib = new CiscoLibrary();
		try {
			lib.add(bk);

		} catch (InvalidBookException i) {
		} catch (BookNotFoundException i) {
			fail();
		} catch (LibraryException i) {
			fail();
		}
	}
}
