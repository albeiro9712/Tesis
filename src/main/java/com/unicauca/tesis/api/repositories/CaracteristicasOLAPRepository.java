package com.unicauca.tesis.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.tesis.api.models.entities.CaracteristicasOLAP;

@Repository
public interface CaracteristicasOLAPRepository extends JpaRepository<CaracteristicasOLAP, Long> {

}
