package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import beans.Ausgabe;
import beans.BookBeanRemote;
import entities.Book;

@SessionScoped
@Named
public class HomeForm implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private Ausgabe ausgabe;

	@EJB
	private BookBeanRemote bookEJB;

	public String getBeispielWert() {
		System.out.println("Ausgabe Controller-Bean");
		return ausgabe.getBeispielText();
	}

	public void doCreateBook(ActionEvent event) {
		Book book = new Book();
		book.setTitle("Herr der Welten");
		book.setPrice(10F);
		book.setDescription("One of the best SciFi-Books");
		book.setIsbn("1-84383-332-2");
		book.setNbOfPage(512);
		book.setIllustrations(false);

		bookEJB.createBook(book);

		book.setTitle("HDW");
		bookEJB.updateBook(book);
	}

	public String getTitle() {
		Book book;
		List<Book> bookList;
		bookList = bookEJB.findBooks();
		try {
			book = bookList.get(0);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return "Noch kein Buch vorhanden!";
		}
		return book.getTitle();

	}

	public int getNumberBooks() {
		List<Book> bookList = bookEJB.findBooks();
		return bookList.size();
	}

}
