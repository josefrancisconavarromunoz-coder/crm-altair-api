# CRM Altair - API de tutorías

API REST de ejemplo basada en la estructura de capas del material UT4. La funcionalidad principal elegida es consultar tutorías.

## Tecnologías
- Java 25 y Spring Boot 4.1.1
- Spring WebMVC
- Spring Data JPA
- PostgreSQL
- Maven

## Configuración
1. Crear la base de datos PostgreSQL `altair` y el esquema `crm`.
2. Editar `src/main/resources/application.properties` y poner el usuario y la contraseña de tu PostgreSQL local. No publiques contraseñas reales en GitHub.
3. Ejecutar `ApicrmApplication` desde el IDE o con `mvnw.cmd spring-boot:run` en Windows.

## Endpoints
| Método | Ruta | Uso |
|---|---|---|
| GET | `/api/tutorias` | Consultar todas las tutorías |
| GET | `/api/tutorias/{id}` | Consultar una tutoría por ID |
| POST | `/api/tutorias` | Crear una tutoría de prueba |
| PUT | `/api/tutorias/{id}` | Actualizar una tutoría |
| DELETE | `/api/tutorias/{id}` | Eliminar una tutoría |

## Ejemplo JSON
```json
{
  "titulo": "Matemáticas",
  "descripcion": "Tutoría de matemáticas de nivel básico",
  "profesor": "Profesor de prueba",
  "precio": 20.0,
  "disponible": true
}
```

## Pruebas
Las peticiones están en `src/pruebas.http`. Se pueden ejecutar desde un cliente HTTP compatible o copiar a Postman.
