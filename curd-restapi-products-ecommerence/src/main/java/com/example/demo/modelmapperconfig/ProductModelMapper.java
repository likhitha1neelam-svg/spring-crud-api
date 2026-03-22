package com.example.demo.modelmapperconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper; ////It is a library used to convert one object to another automatically


@Configuration
public class ProductModelMapper {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
