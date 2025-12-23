package com.evertecinc.data.app.services;

import com.evertecinc.entitydto.app.batch.model.dto.RegistroCSVDTO;
import java.util.List;

/**
 * Interfaz para los servicios de base de datos.
 * 
 * @author Evertec Inc.
 * @version 1.0.0
 */
public interface IBatch {
	
	/**
	 * Guarda una lista de registros en la base de datos
	 * @param listaRegistros Lista de registros DTO a guardar
	 * @return Mensaje de resultado
	 */
	String saveRegistros(List<RegistroCSVDTO> listaRegistros);
	
	/**
	 * Obtiene todos los registros de la base de datos
	 * @return Lista de todos los registros como DTOs
	 */
	List<RegistroCSVDTO> getAllRegistros();
	
	/**
	 * Obtiene un registro por su ID
	 * @param id ID del registro
	 * @return Registro encontrado como DTO o null si no existe
	 */
	RegistroCSVDTO getRegistroById(Long id);
}

