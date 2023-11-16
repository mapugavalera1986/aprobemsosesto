package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSalon;
	private String nombre;
	private Integer capacidad;
}
