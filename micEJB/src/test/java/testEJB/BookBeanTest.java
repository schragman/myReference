package testEJB;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.BookBean;
import entities.Book;

public class BookBeanTest {

	private static EJBContainer ec;
	private static Context ctx;

	@BeforeClass
	public static void initContainer() throws Exception {
		Properties p = new Properties();
		p.put("/myRefDS", "new://Resource?type=DataSource");
		p.put("/myRefDS.JdbcDriver", "org.apache.derby.jdbc.EmbeddedDriver");
		p.put("/myRefDS.JdbcUrl", "jdbc:derby:memory:myTestRefDB;create=true");
//		p.put("/myRefDS.JdbcDriver", "org.apache.derby.jdbc.ClientDriver");
//		p.put("/myRefDS.JdbcUrl", "jdbc:derby://localhost:1527/myTestRefDB;create=true");
		p.put("/myRefDS.UserName", "APP");
		p.put("/myRefDS.Password", "APP");

		ec = EJBContainer.createEJBContainer(p);
		ctx = ec.getContext();
	}

	@AfterClass
	public static void closeContainer() throws Exception {
		ec.close();
	}

	@Test
	public void shouldCreateBook() throws Exception {
		//Creates an instance of book
		Book book = new Book();
		book.setTitle("The Hitchhiker's Guide to the Galaxy");
		book.setPrice(12.5F);
		book.setDescription("Science Fiction comedy book");
		book.setIsbn("1-84023-742-2");
		book.setNbOfPage(354);
		book.setIllustrations(false);

		//Look up the EJB
		BookBean bookBean = (BookBean) ctx.lookup("java:global/micEJB/BookBean");

		//Persists the book to the database
		book = bookBean.createBook(book);
		assertNotNull("ID should not be null", book.getId());

		//Retrieves all the books from the database
		List<Book> books = bookBean.findBooks();
		assertNotNull(books);
	}


}
