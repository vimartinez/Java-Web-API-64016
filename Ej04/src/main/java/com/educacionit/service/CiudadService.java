package com.educacionit.service;


import java.util.ArrayList;
import java.util.List;

import com.educacionit.dao.CitiesDao;
import com.educacionit.dao.CountriesDao;
import com.educacionit.dao.StatesDao;
import com.educacionit.dto.CiudadDTO;
import com.educacionit.model.City;
import com.educacionit.model.Country;
import com.educacionit.model.State;

public class CiudadService {
	
	private CountriesDao countriesDao = new CountriesDao();
	private StatesDao statesDao = new StatesDao();
    private CitiesDao citiesDao = new CitiesDao();

    //Luego de DTO getAll
	public CiudadDTO getById(long cityId) {
		CiudadDTO ciudadesDTO = new CiudadDTO();
		City cityAux = citiesDao.getById(cityId);
		if (cityAux != null) {
			ciudadesDTO.setCityName(cityAux.getName());
			State stateAux = statesDao.getById(cityAux.getId_state());
			if (stateAux != null) {
				ciudadesDTO.setStateName(stateAux.getName());
				Country countryAux = countriesDao.getById(stateAux.getId_country());
				if (countryAux != null) ciudadesDTO.setCountryName(countryAux.getName());
			}
			
		}
		return ciudadesDTO;
	}

	public Boolean add(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean upd(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean del(City city) {
		// TODO Auto-generated method stub
		return null;
	}
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
