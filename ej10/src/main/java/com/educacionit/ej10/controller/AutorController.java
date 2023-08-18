package com.educacionit.ej10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.ej10.model.Autor;
import com.educacionit.ej10.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	AutorService autorService;
	
	@GetMapping(value="/")
	public @ResponseBody List<Autor> getAllAutores(){
		return autorService.getAllAutores();
		
	}

}
