package beans;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface Ausgabe {
	String getBeispielText();

}
