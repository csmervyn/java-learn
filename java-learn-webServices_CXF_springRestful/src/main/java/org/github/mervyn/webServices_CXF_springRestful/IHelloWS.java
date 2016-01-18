package org.github.mervyn.webServices_CXF_springRestful;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public interface IHelloWS {
	
	@GET
	@Path("/HelloWS/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,"text/json;charset=UTF-8"})
	User getUserById(@PathParam("id")int id);
	//,"text/html; charset=UTF-8"}
}
