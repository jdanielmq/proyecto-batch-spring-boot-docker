# Batch DL Data MySQL

Servicio de base de datos MySQL para gestión de registros usando Spring Boot y JPA.

## 🚀 Inicio Rápido

### Compilar y Agregar a Spring Dashboard

Para compilar el proyecto y agregarlo al Spring Dashboard (VS Code o IntelliJ), consulta las instrucciones completas en:

📖 **[SPRING_DASHBOARD.md](./SPRING_DASHBOARD.md)**

**Compilación rápida:**
```bash
# Opción 1: Usar el script de compilación
./build.sh

# Opción 2: Compilar manualmente
cd ../batch-entity-dto && mvn clean install
cd ../batch-dl-data-mysql && mvn clean install
```

## 📋 Descripción

Este proyecto es un servicio REST que permite guardar y consultar registros en una base de datos MySQL. Utiliza DTOs (`RegistroCSVDTO`) para la comunicación con el cliente y entidades JPA (`RegistroCSV`) para la persistencia.

## 🏗️ Estructura del Proyecto

```
com.evertecinc.data.app
├── controller
│   └── BatchController.java      # Controlador REST
├── services
│   ├── IBatch.java              # Interfaz de servicios
│   └── BatchImp.java            # Implementación de servicios
├── repository
│   └── RegistroRepository.java  # Repositorio JPA (usa RegistroCSV del JAR externo)
└── config
    └── JpaConfig.java           # Configuración JPA
```

## 🔧 Configuración

### 1. Archivo `.env`

Crea un archivo `.env` en la raíz del proyecto con la siguiente configuración:

```env
# Base de datos MySQL
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/spring_batch_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=Evertec.2025

# Puerto del servidor
SERVER_PORT=8585

# JPA/Hibernate
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_SHOW_SQL=true

# Logging
LOGGING_LEVEL_ROOT=INFO
LOGGING_LEVEL_APP=DEBUG
```

**Nota:** Puedes usar el archivo `.env.example` como plantilla.

### 2. Base de Datos

Asegúrate de que MySQL esté corriendo y que la base de datos `spring_batch_db` exista:

```sql
CREATE DATABASE IF NOT EXISTS spring_batch_db;
```

## 🚀 Ejecución

### Compilar el proyecto

```bash
mvn clean install
```

### Ejecutar la aplicación

```bash
mvn spring-boot:run
```

O si usas variables de entorno desde `.env`:

```bash
# Cargar variables del .env y ejecutar
export $(cat .env | xargs) && mvn spring-boot:run
```

## 📡 Endpoints

### 1. Guardar registros

```bash
POST http://localhost:8585/api/mysql/dl/save/mandato
Content-Type: application/json
```

**Body (JSON):**
```json
[
  {
    "nombre": "Juan Pérez",
    "edad": 25,
    "email": "juan.perez@example.com",
    "fechaProceso": "2025-01-20T10:30:00"
  },
  {
    "nombre": "María García",
    "edad": 30,
    "email": "maria.garcia@example.com",
    "fechaProceso": "2025-01-20T10:30:00"
  }
]
```

**Ejemplo con curl:**
```bash
curl -X POST http://localhost:8585/api/mysql/dl/save/mandato \
  -H "Content-Type: application/json" \
  -d '[{"nombre":"Juan Pérez","edad":25,"email":"juan.perez@example.com","fechaProceso":"2025-01-20T10:30:00"}]'
```

### 2. Consultar todos los registros

```bash
GET http://localhost:8585/api/mysql/dl/registros
```

**Ejemplo:**
```bash
curl http://localhost:8585/api/mysql/dl/registros
```

**Respuesta (JSON):**
```json
[
  {
    "id": 1,
    "nombre": "JUAN PÉREZ",
    "edad": 25,
    "email": "juan.perez@example.com",
    "fechaProceso": "2025-01-20T10:30:00"
  }
]
```

### 3. Consultar un registro por ID

```bash
GET http://localhost:8585/api/mysql/dl/registros/{id}
```

**Ejemplo:**
```bash
curl http://localhost:8585/api/mysql/dl/registros/1
```

**Respuesta (JSON):**
```json
{
  "id": 1,
  "nombre": "JUAN PÉREZ",
  "edad": 25,
  "email": "juan.perez@example.com",
  "fechaProceso": "2025-01-20T10:30:00"
}
```

## 📦 Dependencias

- **Spring Boot 4.0.0**
- **Spring Data JPA**
- **MySQL Connector**
- **batch-entity-dto** (JAR externo con entidades y DTOs)

## 🔍 Verificación

### Health Check

```bash
curl http://localhost:8585/actuator/health
```

### Verificar que la aplicación está corriendo

```bash
curl http://localhost:8585/api/mysql/dl/registros
```

## 📌 Notas

- El proyecto utiliza la entidad `RegistroCSV` y el DTO `RegistroCSVDTO` del JAR externo `batch-entity-dto`
- La configuración de base de datos se lee desde el archivo `.env`
- El puerto por defecto es `8585`
- Los endpoints trabajan exclusivamente con DTOs (`RegistroCSVDTO`)
- El servicio guarda directamente en la base de datos sin usar Spring Batch

## 🔄 Flujo de Datos

1. **Cliente → Controller**: Envía `List<RegistroCSVDTO>` en el POST
2. **Controller → Service**: Pasa los DTOs al servicio
3. **Service**: Convierte DTOs a Entidades usando `EntityDTOMapper`
4. **Service → Repository**: Guarda las entidades en la BD
5. **Consulta**: Convierte Entidades a DTOs antes de retornar
