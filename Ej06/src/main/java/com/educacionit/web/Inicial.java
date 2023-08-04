package com.educacionit.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/inicial")
public class Inicial {

	//localhost + proyexto + nombreconfig + clase + metodo 
	//http://localhost:8080/Ej06/rest/inicial/salu
	
	@GET
	@Path("/salu")
	public String saludo() {
		return "Hola API Rest";
	}
}
