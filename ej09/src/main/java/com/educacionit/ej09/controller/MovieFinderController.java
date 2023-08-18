package com.educacionit.ej09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.ej09.dto.MovieDTO;
import com.educacionit.ej09.service.MovieFinderService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/moviefinder")
@CrossOrigin
public class MovieFinderController {
	
	@Autowired MovieFinderService movieFinderService;
	
	@GetMapping(value="/", produces="Application/json")
	public List<MovieDTO> getMoviesByName(@Parameter(description="Nombre a buscar") @RequestParam(value="Nombre") String movieName){
		return movieFinderService.getMoviesByName(movieName);
		
	}

}
