package com.educacionit.ej10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.ej10.model.Autor;

public interface AutorRespository extends JpaRepository<Autor, Long> {

}
