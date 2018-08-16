package controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import beans.Ausgabe;

@SessionScoped
@Named
public class HomeForm implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private Ausgabe ausgabe;

	public String getBeispielWert() {
		System.out.println("Ausgabe Controller-Bean");
		return ausgabe.getBeispielText();
	}

}
