package com.educacionit.service;


import java.util.ArrayList;
import java.util.List;

import com.educacionit.dao.CountriesDao;
import com.educacionit.dao.StatesDao;
import com.educacionit.dto.CiudadDTO;
import com.educacionit.model.Country;
import com.educacionit.model.State;

public class CiudadService {
	
	private CountriesDao countriesDao = new CountriesDao();
	private StatesDao statesDao = new StatesDao();

	public List<CiudadDTO> getAllCities() {
		List<Country> countries = countriesDao.getAll();
		List<State> states = statesDao.getAll();
		
		List<CiudadDTO> ciudades = new ArrayList<>();
		
		for (Country country : countries) {
			for (State state : states) {
				if(country.getId() == state.getId_country()) {
					CiudadDTO cityAux = new CiudadDTO();
					cityAux.setStateName(state.getName());
					cityAux.setCountryName(country.getName());
					ciudades.add(cityAux);
				}
			}
		}
		
		return ciudades;
		
	}
}
