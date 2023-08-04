package com.educacionit.web.v2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.educacionit.model.User;
import com.educacionit.service.UserService;

@Path("/V2/users")
public class UserRestController {
	
	UserService userService = new UserService();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") Long id) {
		
		User usuarioObtenido = userService.getUserById(id);
		if (usuarioObtenido != null){
			return Response
					.status(Response.Status.OK)
					.entity(usuarioObtenido)
					.build();
			
		} else {
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity("{\"mensaje\":\"No se encontró un usuario con el id: " + id +"\"}")
					.type(MediaType.TEXT_PLAIN)
					.build();
			
		}
		
	}

}
