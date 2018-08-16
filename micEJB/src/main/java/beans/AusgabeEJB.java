package beans;

import javax.ejb.Stateless;

@Stateless
public class AusgabeEJB implements Ausgabe {

	@Override
	public String getBeispielText() {
		System.out.println("Ausgabe EJB");
		return "Das ist der Beispieltext";
	}

}
