package beans;

import javax.ejb.Remote;

@Remote
public interface Ausgabe {
	String getBeispielText();

}
