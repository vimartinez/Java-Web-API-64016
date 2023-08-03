package com.educacionit.ws;

import java.util.List;

import com.educacionit.dto.CiudadDTO;
import com.educacionit.model.City;
import com.educacionit.service.CiudadService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;

@WebService
public class CiudadesWs {
	
	CiudadService ciudadService = new CiudadService();
	
	@WebMethod(operationName = "GetCity")
	@WebResult(name="City")
	public CiudadDTO getCityById(@WebParam(name="CityoId")@XmlElement(required=true,nillable=false)long CityId) {
		return ciudadService.getById(CityId);
	}

	@WebMethod(operationName = "addCity")
	@WebResult(name="city")
	public Boolean addCity(City city) {
		return ciudadService.add(city);
	}

	@WebMethod
	public Boolean updCity(City city) {
		return ciudadService.upd(city);
	}


	@WebMethod
	public Boolean delCity(City city) {
		return ciudadService.del(city);
	}

	@WebMethod
	public List<CiudadDTO> getAllCities() {
		return ciudadService.getAllCities();
	}


}
