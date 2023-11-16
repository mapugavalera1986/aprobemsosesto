package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.Alumno;
import com.cibertec.repository.AlumnoRepository;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoRepository repo;

	@GetMapping
	public ResponseEntity<Object> getAllAlumnos() {
		List<Alumno> alumnos = repo.findAll();
		if (!alumnos.isEmpty()) {
			return ResponseEntity.ok(alumnos);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron alumnos.");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getAlumno(@PathVariable Integer id) {
		Optional<Alumno> optionalAlumno = repo.findById(id);
		if (optionalAlumno.isPresent()) {
			return ResponseEntity.ok(optionalAlumno.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el alumno con ID " + id);
		}
	}

	@PostMapping
	public ResponseEntity<String> createAlumno(@RequestBody Alumno alumno) {
		repo.save(alumno);
		String mensaje = "Alumno: " + alumno.getNombres() + " " + alumno.getApellidos() + ", creado correctamente.";
		return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateAlumno(@PathVariable Integer id, @RequestBody Alumno alumno) {
		Optional<Alumno> optionalAlumno = repo.findById(id);
		if (optionalAlumno.isPresent()) {
			Alumno existingAlumno = optionalAlumno.get();
			existingAlumno.setNombres(alumno.getNombres());
			existingAlumno.setApellidos(alumno.getApellidos());
			existingAlumno.setDni(alumno.getDni());
			existingAlumno.setCelular(alumno.getCelular());
			existingAlumno.setDireccion(alumno.getDireccion());
			repo.save(existingAlumno);
			String mensaje = "Alumno con ID " + id + " ha sido actualizado correctamente.";
			return ResponseEntity.status(HttpStatus.OK).body(mensaje);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno no encontrado con ID " + id);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAlumno(@PathVariable Integer id) {
		Optional<Alumno> optionalAlumno = repo.findById(id);
		if (optionalAlumno.isPresent()) {
			repo.delete(optionalAlumno.get());
			String mensaje = "Alumno con ID " + id + " ha sido eliminado correctamente.";
			return ResponseEntity.status(HttpStatus.OK).body(mensaje);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno no encontrado con ID " + id);
		}
	}
}