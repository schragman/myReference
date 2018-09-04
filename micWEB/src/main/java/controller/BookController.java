package controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import beans.BookBean;
import entities.Book;

@RequestScoped
@Named
public class BookController {
	@EJB
	private BookBean bookEJB;

	private Book book = new Book();

	public Book getBook() {
		return book;
	}


	public String doCreateBook() {

		String returnPage;
		FacesContext ctx = FacesContext.getCurrentInstance();

		if (book.getIsbn()==null || "".equals(book.getIsbn())) {
				ctx.addMessage("bookForm:isbn", new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Wrong ISBN", "You should enter an ISBN number"));
//			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
//				"Wrong ISBN", "You should enter an ISBN number"));
			returnPage=null;
		} else {
			bookEJB.createBook(book);
			returnPage="home";
		}
		return returnPage;
	}


}
