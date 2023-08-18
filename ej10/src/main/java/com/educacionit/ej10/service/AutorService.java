package com.educacionit.ej10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.ej10.model.Autor;
import com.educacionit.ej10.repository.AutorRespository;

@Service
public class AutorService {
	
	@Autowired
	AutorRespository autorRepository;

	public List<Autor> getAllAutores() {
		return autorRepository.findAll();
	}

}
