package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class HomeTobago {
	
	public String goToPopUpTest() {
		return "popUpTest";
	}
	
}
