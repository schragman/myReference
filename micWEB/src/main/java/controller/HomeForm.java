package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import beans.Ausgabe;
import beans.AusgabeEJB2;
import beans.BookBeanRemote;
import entities.Book;

@SessionScoped
@Named
public class HomeForm implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private Ausgabe ausgabe;
	@EJB
	private AusgabeEJB2 ausgabe2;

	@EJB
	private BookBeanRemote bookEJB;

	public String getBeispielWert() {
		System.out.println("Ausgabe Controller-Bean");
		return ausgabe.getBeispielText();
	}

	public String getBeispiel2() {
		return ausgabe2.getBeispielText();
	}

	public String doCreateBook() {
		return "newBook";
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

	public List<Book> getBookList() {
		return bookEJB.findBooks();
	}

}
