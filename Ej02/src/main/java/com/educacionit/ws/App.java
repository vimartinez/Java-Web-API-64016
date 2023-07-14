package com.educacionit.ws;

import jakarta.xml.ws.Endpoint;

public class App {

	public static void main(String[] args) {
		System.out.println("Inicianco el WS Dado");
		Endpoint.publish("http://localhost:8081/Ej01/tirardado", new Dado());
		Endpoint.publish("http://localhost:8081/Ej01/tirardados", new Dado());
		Endpoint.publish("http://localhost:8081/Ej01/tirargenerala", new Dado());

	}

}
