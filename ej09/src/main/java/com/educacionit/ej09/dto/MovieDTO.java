package com.educacionit.ej09.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
	private Long id;
	private String name;
	private String summary;
	private String cover;
}
