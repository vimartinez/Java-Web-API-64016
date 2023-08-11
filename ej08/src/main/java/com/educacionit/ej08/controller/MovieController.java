package com.educacionit.ej08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.ej08.model.Movie;
import com.educacionit.ej08.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping(value="/")
	@Operation(summary="Devuelve el listado de todas las películas de la base sin paginación", description="No recibe argumentos de entrada", tags = {"Pelis"})
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description= "Está todo bien"),
			@ApiResponse(responseCode = "404", description = "No se encontraron películas en la bd!")
	})
	public @ResponseBody List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}

}
