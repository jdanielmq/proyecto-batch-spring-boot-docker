# Guía de Instalación y Uso

## Instalación Local

Para instalar el proyecto en tu repositorio Maven local:

```bash
mvn clean install
```

Esto instalará el JAR en `~/.m2/repository/com/evertecinc/entitydto/batch-entity-dto/1.0.0/`

## Uso en Otro Proyecto Maven

### 1. Agregar la dependencia en `pom.xml`

```xml
<dependency>
    <groupId>com.evertecinc.entitydto</groupId>
    <artifactId>batch-entity-dto</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2. Ejemplo de uso en un proyecto Spring Boot

```java
import com.evertecinc.entitydto.app.batch.model.entity.RegistroCSV;
import com.evertecinc.entitydto.app.batch.model.dto.RegistroCSVDTO;
import com.evertecinc.entitydto.app.utils.EntityDTOMapper;

// En tu repositorio JPA
@Repository
public interface RegistroRepository extends JpaRepository<RegistroCSV, Long> {
    // Métodos personalizados si es necesario
}

// En tu servicio
@Service
public class RegistroService {
    
    @Autowired
    private RegistroRepository repository;
    
    public RegistroCSVDTO guardarRegistro(RegistroCSVDTO dto) {
        RegistroCSV entity = EntityDTOMapper.toNewEntity(dto);
        RegistroCSV saved = repository.save(entity);
        return EntityDTOMapper.toDTO(saved);
    }
    
    public List<RegistroCSVDTO> obtenerTodos() {
        return repository.findAll().stream()
            .map(EntityDTOMapper::toDTO)
            .collect(Collectors.toList());
    }
}
```

## Estructura de Paquetes

```
com.evertecinc.entitydto.app.batch
├── model
│   ├── entity          # Entidades JPA
│   │   └── RegistroCSV.java
│   └── dto             # Data Transfer Objects
│       └── RegistroCSVDTO.java
└── utils               # Utilidades compartidas
    └── EntityDTOMapper.java
```

## Versión

**Versión actual:** 1.0.0

## Requisitos

- Java 25
- Jakarta Persistence API 3.2.0
- Maven 3.9+

