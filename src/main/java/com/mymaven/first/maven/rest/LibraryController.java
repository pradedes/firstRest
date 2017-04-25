package com.mymaven.first.maven.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mymaven.first.maven.api.Book;
import com.mymaven.first.maven.api.Library;
import com.mymaven.first.maven.service.CiscoLibrary;

@Path("library")
public class LibraryController {
	private static Library library = new CiscoLibrary();

	@POST
	@Path("/book")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Book book) {
		System.out.println("LibraryController.add()***********");
		library.add(book);
		return Response.ok().build();
	}

	@GET
	@Path("/book/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("isbn") int isbn) {
		System.out.println("get book************");
		Book book = library.find(isbn);
		return Response.ok().entity(book).build();
	}

	
//	@GET
//	@Path("/book/ajax")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response find(@PathParam("isbn") int isbn) {
//		Book book = library.find(isbn);
//		return Response.ok().entity(book).build();
//	}
	
	  @GET
	  @Path("/book/ajax")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello example rest";
	  }
}
