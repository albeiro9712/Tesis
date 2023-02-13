package com.unicauca.tesis.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unicauca.tesis.api.models.entities.CaracteristicasSGBD;

@Repository
public interface CaracteristicasBDRepository extends JpaRepository<CaracteristicasSGBD, Long> {

	@Query(value = "select caracteristicas_bd from caracteristicas_bd  JOIN herramientas on (caracteristicas_bd.id_herramienta =herramientas.id_herramienta) JOIN servicios on (herramientas.id_servicio=servicios.id_servicio)"
			+ " WHERE servicios.nombre = :nombreServicio", nativeQuery = true)
	public List<CaracteristicasSGBD> getCaracteristicasSGBDByHerramienta(
			@Param("nombreServicio") String nombreServicio);
}
