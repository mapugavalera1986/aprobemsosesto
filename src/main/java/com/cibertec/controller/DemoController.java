package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.model.User;
import com.cibertec.repository.UserRepository;

@RestController
@RequestMapping("api/v1")
public class DemoController {

	@Autowired
	UserRepository repo;
	
	@PostMapping(value = "demo")
	public String welcome() {
		return "Bienvenido el curso de seguridad de java con spring boot";
	}
	
	
	@GetMapping(value = "listar")
	//@PreAuthorize("hasRole('ADMIN')")
	public List<User> listar(){
		List<User> lista = repo.findAll();
		return lista;
	}
}
