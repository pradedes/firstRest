package com.mymaven.first.maven.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mymaven.first.maven.api.Book;

public class JPALibraryDAO implements LibraryDAO {
	private EntityManagerFactory factory= Persistence.createEntityManagerFactory("com.myrest");
	
	@Override
	public void create(Book book) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();;
		em.close();
	
	}

	@Override
	public Book read(int isbn) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Book book = em.find(Book.class,isbn);
		em.getTransaction().commit();;
		em.close();
		return book;
	}

}
