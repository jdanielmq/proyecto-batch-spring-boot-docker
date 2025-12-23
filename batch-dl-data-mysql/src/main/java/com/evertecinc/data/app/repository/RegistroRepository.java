package com.evertecinc.data.app.repository;

import com.evertecinc.entitydto.app.batch.model.entity.RegistroCSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad RegistroCSV.
 * Utiliza la entidad del JAR externo batch-entity-dto.
 * 
 * @author Evertec Inc.
 * @version 1.0.0
 */
@Repository
public interface RegistroRepository extends JpaRepository<RegistroCSV, Long> {
}

