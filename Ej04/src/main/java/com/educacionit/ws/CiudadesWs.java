package com.educacionit.ws;

import java.util.List;

import com.educacionit.dto.CiudadDTO;
import com.educacionit.service.CiudadService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class CiudadesWs {
	
	CiudadService ciudadService = new CiudadService();

	@WebMethod
	public List<CiudadDTO> getAllCities() {
		return ciudadService.getAllCities();
	}


}
