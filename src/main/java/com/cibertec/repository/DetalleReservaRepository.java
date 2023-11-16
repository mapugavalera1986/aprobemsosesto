package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.Curso;
import com.cibertec.model.DetalleReserva;

public interface DetalleReservaRepository extends JpaRepository<DetalleReserva, Curso>{

}
