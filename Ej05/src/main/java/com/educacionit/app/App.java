package com.educacionit.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import com.educacionit.ws.DadoPortBindingStub;
import com.educacionit.ws.DadoServiceLocator;

public class App {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException {
		
		DadoServiceLocator dadoServiceLocator = new DadoServiceLocator();
		DadoPortBindingStub dadoPortBindingStub = new DadoPortBindingStub(new URL(dadoServiceLocator.getDadoPortAddress()), dadoServiceLocator);
		
		System.out.println("Tirar dado de 6 caras:" + dadoPortBindingStub.tirarDado());
		System.out.println("Tirar dado de 20 caras:" + dadoPortBindingStub.tirarDiferentesDados(20));
		
	}

}
