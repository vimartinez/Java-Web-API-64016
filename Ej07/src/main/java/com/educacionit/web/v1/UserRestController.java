package com.educacionit.web.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/V1/users")
public class UserRestController {
	
	//http://localhost:8080/Ej07/rest/V1/users/5
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserById(@PathParam("id") Long id) {
		return "{\"mensaje\":\"El id de usuario enviado es: " + id +"\"}";
		
	}

}
