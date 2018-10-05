package controller;

import java.net.URI;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import beans.BookBean;
import entities.Book;

//http://localhost:8080/ReferenceII/rest/books
@Path("/books")
@ApplicationPath("/rest")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class BookRestController extends Application{

	@Context
	private UriInfo uriInfo;

	@EJB
	private BookBean bookBean;

	//http://localhost:8080/ReferenceII/rest/books/2
	@GET
	@Path("{id}/")
	public Response getUriBookById(@PathParam("id") Long id) {
		Book book = bookBean.findBookById(id);
		//URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();

		return Response.ok(book).build();
		//return "say Michael";
	}

	//http://localhost:8080/ReferenceII/rest/books/id?bookId=2
	@GET
	@Path("id/")
	public Response getRestBookById(@QueryParam("bookId") Long id) {
		Book book = bookBean.findBookById(id);
		return Response.ok(book).build();
	}

	//http://localhost:8080/ReferenceII/rest/books/jid?bookId=2
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("jid/")
	public Response getJasonBookById(@QueryParam("bookId") Long id) {
		Book book = bookBean.findBookById(id);
		return Response.ok(book).build();
	}

}
