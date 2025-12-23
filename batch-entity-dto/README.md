# Batch Entity DTO

Proyecto de entidades y DTOs reutilizables para proyectos batch.

## Descripción

Este proyecto contiene las entidades JPA y DTOs que pueden ser reutilizados en múltiples proyectos batch. Está diseñado como un módulo independiente que puede ser incluido como dependencia en otros proyectos Maven.

## Estructura del Proyecto

```
com.evertecinc.entitydto.app.batch
├── model
│   ├── entity          # Entidades JPA
│   └── dto             # Data Transfer Objects
└── utils               # Utilidades compartidas
```

## Versión

**Versión actual:** 1.0.0

## Uso

### Incluir en otro proyecto Maven

Agregar la siguiente dependencia en el `pom.xml`:

```xml
<dependency>
    <groupId>com.evertecinc.entitydto</groupId>
    <artifactId>batch-entity-dto</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Instalación Local

Para instalar el proyecto en el repositorio local de Maven:

```bash
mvn clean install
```

### Publicación en Repositorio Maven

Para publicar en un repositorio Maven corporativo, configurar la distribución en `pom.xml` y ejecutar:

```bash
mvn clean deploy
```

## Requisitos

- Java 25
- Maven 3.9+
- Jakarta Persistence API 3.2.0

## Licencia

Copyright © Evertec Inc.

