package com.educacionit.web.v2;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.educacionit.model.User;
import com.educacionit.service.UserService;
import com.educacionit.util.Mensaje;

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
					.type(MediaType.APPLICATION_JSON)
					.build();
			
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers(){
		return Response
				.status(Response.Status.OK)
				.entity(userService.getAllUsers())
				.type(MediaType.APPLICATION_JSON)
				.build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		Mensaje mensajeRespuesta = new Mensaje();
		if (userService.addUser(user)){
			mensajeRespuesta.setMensaje("Se generó el usuario correctamente");
			return Response
					.status(Response.Status.CREATED)
					.entity(mensajeRespuesta)
					.type(MediaType.APPLICATION_JSON)
					.build();
			
		} else {
			mensajeRespuesta.setMensaje("No se pudo generar el usuario");
			return Response
					.status(Response.Status.CONFLICT)
					.entity(mensajeRespuesta)
					.type(MediaType.APPLICATION_JSON)
					.build();
			
		}
		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delUser(User user) {
		Mensaje mensajeRespuesta = new Mensaje();
		if (userService.delUser(user)){
			mensajeRespuesta.setMensaje("Se eliminó el usuario correctamente");
			return Response
					.status(Response.Status.OK)
					.entity(mensajeRespuesta)
					.type(MediaType.APPLICATION_JSON)
					.build();
			
		} else {
			mensajeRespuesta.setMensaje("No se pudo eliminar el usuario");
			return Response
					.status(Response.Status.CONFLICT)
					.entity(mensajeRespuesta)
					.type(MediaType.APPLICATION_JSON)
					.build();
			
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updUser(User user) {
		Mensaje mensajeRespuesta = new Mensaje();
		if (userService.updUser(user)){
			mensajeRespuesta.setMensaje("Se actualizó el usuario correctamente");
			return Response
					.status(Response.Status.OK)
					.entity(mensajeRespuesta)
					.type(MediaType.APPLICATION_JSON)
					.build();
			
		} else {
			mensajeRespuesta.setMensaje("No se pudo actualizar el usuario");
			return Response
					.status(Response.Status.CONFLICT)
					.entity(mensajeRespuesta)
					.type(MediaType.APPLICATION_JSON)
					.build();
			
		}
		
	}

}
