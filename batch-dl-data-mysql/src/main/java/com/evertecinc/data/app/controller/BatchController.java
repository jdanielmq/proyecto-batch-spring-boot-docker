package com.evertecinc.data.app.controller;

import com.evertecinc.entitydto.app.batch.model.dto.RegistroCSVDTO;
import com.evertecinc.data.app.services.IBatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para los endpoints de servicio de base de datos.
 * 
 * @author Evertec Inc.
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/mysql/dl")
public class BatchController {

	@Autowired
	private IBatch batchService;

	/**
	 * Guardar una lista de registros en la base de datos
	 * 
	 * @param listaRegistros Lista de registros DTO a guardar
	 * @return Mensaje de resultado
	 */
	@PostMapping("/save/mandato")
	public ResponseEntity<String> saveRegistros(@RequestBody List<RegistroCSVDTO> listaRegistros) {
		try {
			String resultado = batchService.saveRegistros(listaRegistros);
			return ResponseEntity.ok(resultado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("❌ Error al guardar los registros: " + e.getMessage());
		}
	}

	/**
	 * Consultar todos los Registros
	 * 
	 * @return Lista de todos los registros como DTOs
	 */
	@GetMapping("/mandato/registros")
	public ResponseEntity<List<RegistroCSVDTO>> getAllRegistros() {
		try {
			List<RegistroCSVDTO> registros = batchService.getAllRegistros();
			return ResponseEntity.ok(registros);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Consultar Detalles de un Registro por ID
	 * 
	 * @param id ID del registro
	 * @return Registro encontrado como DTO
	 */
	@GetMapping("/mandato/registro/{id}")
	public ResponseEntity<RegistroCSVDTO> getRegistroById(@PathVariable Long id) {
		try {
			RegistroCSVDTO registro = batchService.getRegistroById(id);
			if (registro != null) {
				return ResponseEntity.ok(registro);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}

