package com.educacionit.ws;

import java.util.ArrayList;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;

@WebService
public class Dado {
	
	@WebMethod
	public Integer tirarDado() {
		return (int) (Math.random()*6+1);
		
	}
	
	@WebMethod(operationName = "TirarDiferentesDados")
	@WebResult(name="ResultadoDeTirarLosDados")
	public String tirarDadoNCaras(@WebParam(name="CantidadDeCarasDelDado")@XmlElement(required = true) Integer cantidadDeCaras) {
		String resultado = "";
		ArrayList<Integer> carasSoportadas = new ArrayList<Integer>();
		carasSoportadas.add(4);
		carasSoportadas.add(6);
		carasSoportadas.add(8);
		carasSoportadas.add(12);
		carasSoportadas.add(20);
		
		if(carasSoportadas.contains(cantidadDeCaras)) {
			Integer numeroObtenido =  (int) (Math.random()*cantidadDeCaras+1);
			resultado = "Se tiró un dado de "+cantidadDeCaras.toString()+" y salió "+ numeroObtenido;
			System.out.println(resultado);
		}
		else {
			resultado = "No existe un dado de "+cantidadDeCaras.toString()+" caras!";
		}
		
		return resultado;
		
	}
	
	@WebMethod(operationName = "TirarGenerala")
	@WebResult(name="ResultadoDeGenerala")
	public String tirarGenerala(@WebParam(name="CantidadDeDados") Integer cantidadDeDados) {
		String resultado = "";
		if((cantidadDeDados > 0)  && (cantidadDeDados <=5)) {
			for(int i=0; i<cantidadDeDados;i++) {
				resultado = resultado + tirarDado().toString() + " ";
			}
		}
		else {
			resultado = "En la generala hay que tirar entre 1 y 5 dados";
		}
		
		return resultado;
	}
	
}
