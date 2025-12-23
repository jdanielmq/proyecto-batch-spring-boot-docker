package com.evertecinc.data.app.services;

import com.evertecinc.entitydto.app.batch.model.dto.RegistroCSVDTO;
import com.evertecinc.entitydto.app.batch.model.entity.RegistroCSV;
import com.evertecinc.entitydto.app.utils.EntityDTOMapper;
import com.evertecinc.data.app.repository.RegistroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de los servicios de base de datos.
 * 
 * @author Evertec Inc.
 * @version 1.0.0
 */
@Service
public class BatchImp implements IBatch {

	@Autowired
	private RegistroRepository registroRepository;

	/**
	 * Guarda una lista de registros en la base de datos
	 * @param listaRegistros Lista de registros DTO a guardar
	 * @return Mensaje de resultado
	 */
	@Override
	@Transactional
	public String saveRegistros(List<RegistroCSVDTO> listaRegistros) {
		try {
			if (listaRegistros == null || listaRegistros.isEmpty()) {
				return "❌ Error: La lista de registros está vacía";
			}

			// Convertir DTOs a entidades y guardar
			List<RegistroCSV> entidades = listaRegistros.stream()
				.map(EntityDTOMapper::toNewEntity)
				.collect(Collectors.toList());

			registroRepository.saveAll(entidades);

			return "✅ Se guardaron exitosamente " + entidades.size() + " registro(s) en la base de datos";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "❌ Error al guardar los registros: " + e.getMessage();
		}
	}

	/**
	 * Obtiene todos los registros de la base de datos
	 * @return Lista de todos los registros como DTOs
	 */
	@Override
	public List<RegistroCSVDTO> getAllRegistros() {
		List<RegistroCSV> entidades = registroRepository.findAll();
		return entidades.stream()
			.map(EntityDTOMapper::toDTO)
			.collect(Collectors.toList());
	}

	/**
	 * Obtiene un registro por su ID
	 * @param id ID del registro
	 * @return Registro encontrado como DTO o null si no existe
	 */
	@Override
	public RegistroCSVDTO getRegistroById(Long id) {
		return registroRepository.findById(id)
			.map(EntityDTOMapper::toDTO)
			.orElse(null);
	}
}

