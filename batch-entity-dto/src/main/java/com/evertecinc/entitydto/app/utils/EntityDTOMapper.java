package com.evertecinc.entitydto.app.utils;

import com.evertecinc.entitydto.app.batch.model.dto.RegistroCSVDTO;
import com.evertecinc.entitydto.app.batch.model.entity.RegistroCSV;

/**
 * Utilidad para mapear entre entidades JPA y DTOs.
 * 
 * @author Evertec Inc.
 * @version 1.0.0
 */
public class EntityDTOMapper {

    /**
     * Convierte una entidad RegistroCSV a su DTO correspondiente.
     * 
     * @param entity La entidad a convertir
     * @return El DTO correspondiente
     */
    public static RegistroCSVDTO toDTO(RegistroCSV entity) {
        if (entity == null) {
            return null;
        }
        return new RegistroCSVDTO(
            entity.getId(),
            entity.getNombre(),
            entity.getEdad(),
            entity.getEmail(),
            entity.getFechaProceso()
        );
    }

    /**
     * Convierte un DTO RegistroCSVDTO a su entidad correspondiente.
     * 
     * @param dto El DTO a convertir
     * @return La entidad correspondiente
     */
    public static RegistroCSV toEntity(RegistroCSVDTO dto) {
        if (dto == null) {
            return null;
        }
        RegistroCSV entity = new RegistroCSV();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());
        entity.setEmail(dto.getEmail());
        entity.setFechaProceso(dto.getFechaProceso());
        return entity;
    }

    /**
     * Crea una nueva entidad desde un DTO sin ID (para nuevos registros).
     * 
     * @param dto El DTO a convertir
     * @return La entidad nueva sin ID
     */
    public static RegistroCSV toNewEntity(RegistroCSVDTO dto) {
        if (dto == null) {
            return null;
        }
        return new RegistroCSV(
            dto.getNombre(),
            dto.getEdad(),
            dto.getEmail(),
            dto.getFechaProceso()
        );
    }
}

