package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIColumn;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
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

	private UIOutput preis;
	private UICommand myButton;
	private UIOutput myOutput;
	private UIColumn myColumn;
	private UIOutput myOutText;
	private UIComponent myFacet;

	public UIColumn getMyColumn() {
		return myColumn;
	}


	public void setMyColumn(UIColumn myColumn) {
		this.myColumn = myColumn;
	}


	public UIOutput getMyOutput() {
		return myOutput;
	}


	public void setMyOutput(UIOutput myOutput) {
		this.myOutput = myOutput;
	}


	public UICommand getMyButton() {
		return myButton;
	}


	public void setMyButton(UICommand myButton) {
		this.myButton = myButton;
	}


	public UIOutput getPreis() {
		return preis;
	}


	public void setPreis(UIOutput preis) {
		this.preis = preis;
	}


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

	public String doTestBinding() {
		preis.setValue("mein Preis");
		myButton.setValue("mein Test");
		return null;
	}
	
	public String doChangeHome() {
		
		myOutput.setValue("Binding Test");
		
		myFacet = myColumn.getFacet("header");
		myOutText = (UIOutput) myFacet;
//		List<UIComponent> comps = myFacet.getChildren();
//		myOutText = (UIOutput) comps.get(0);
		myOutText.setValue("Neue Überschrift");
		return null;
	}


}
