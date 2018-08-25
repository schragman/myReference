package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class AusgabeEJB2 implements Ausgabe2 {

	@Override
	public String getBeispielText() {
		System.out.println("Ausgabe2 EJB");
		return "Das ist die Ausgabe für LocalBean";
	}

}
