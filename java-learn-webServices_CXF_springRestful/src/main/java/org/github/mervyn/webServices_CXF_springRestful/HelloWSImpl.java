package org.github.mervyn.webServices_CXF_springRestful;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class HelloWSImpl implements IHelloWS {
	
	@GET
	@Path("/HelloWS/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,"text/json;charset=UTF-8"})
	@Override
	public User getUserById(@PathParam("id")int id){
		System.out.println("id为： " + id);
		User user = new User();
		user.setId(id);
		user.setName("贺鑫鑫");
		return user;
	}

}
