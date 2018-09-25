package beans;

import java.net.URI;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import entities.Book;

//http://localhost:8080/ReferenceII/books/rest
@Path("/books")
@ApplicationPath("/rest")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class BookRestResource extends Application{
	@PersistenceContext(unitName = "myRefPU")
	private EntityManager em;
	
	@Context
	private UriInfo uriInfo;
	
	//http://localhost:8080/ReferenceII/books/rest/2
	@GET
	@Path("{id}/")
	public Response getUriBookById(@PathParam("id") Long id) {
		Book book = em.find(Book.class, id);
		URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
		
		return Response.ok(bookUri).build();
	}

}
