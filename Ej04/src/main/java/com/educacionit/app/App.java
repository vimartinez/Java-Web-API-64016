package com.educacionit.app;


import com.educacionit.ws.CiudadesWs;

import jakarta.xml.ws.Endpoint;

public class App {

	public static void main(String[] args) {
System.out.println("Iniciando WebService Ciudades");
		
		Endpoint.publish("http://localhost:8098/jwa04/ciudades", new CiudadesWs());
		System.out.println("http://localhost:8098/jwa04/ciudades");

	}

}
