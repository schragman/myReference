package beans;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

@Path("/MyRest2Service")
@ApplicationPath("/resources2")
public class TestRestEJB extends Application{
	//http://localhost:8080/ReferenceII/resources2/My2RestService/sayMichael
	@GET
	@Path("/sayMichael")
	public String getHelloMsg() {
		return "Hello Michael";
	}
}
