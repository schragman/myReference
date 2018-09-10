package controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.apache.myfaces.tobago.component.UIOperation;

@RequestScoped
@Named
public class HomeTobago {

	private String myEingabe;

	private UIOperation myOperation;

	public UIOperation getMyOperation() {
		return myOperation;
	}

	public void setMyOperation(UIOperation myOperation) {
		this.myOperation = myOperation;
	}

	public String getMyEingabe() {
		return myEingabe;
	}

	public void setMyEingabe(String myEingabe) {
		this.myEingabe = myEingabe;
	}

	public String goToPopUpTest() {
		return "popUpTest";
	}

	public void doChangeOperation(ActionEvent pvEvent) {

		myOperation.setName("hide");
		myOperation.setFor("myPopup");

		FacesContext fc = FacesContext.getCurrentInstance();

	}

}
