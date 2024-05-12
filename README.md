# Practica-java-springboot

## Aplicación Web y API REST para Gestión de Alumnos y Proyectos

Este proyecto consiste en desarrollar una aplicación web y una API REST para gestionar alumnos y proyectos.

### Funcionalidades

- **Aplicación Web**: Permite registrar, actualizar, eliminar y visualizar alumnos. También muestra los proyectos registrados.
- **API REST**: Proporciona operaciones CRUD completas para los proyectos.

### Entidades

1. **Alumnos**: Contiene información como nombre, apellido, teléfono, correo electrónico, DNI y fecha de nacimiento.
2. **Proyecto**: Representa proyectos con nombre, descripción, fechas de inicio y finalización, y estado de activo.

### Ejecución del Proyecto

1. Clonar el repositorio.
2. Configurar y ejecutar el servidor backend.
3. Configurar la base de datos y ejecutar las migraciones.
4. Ejecutar el servidor frontend.

### Comandos Postman

#### 1. Obtener todos los proyectos

- Método: GET
- URL: `http://localhost:8080/proyectos`

#### 2. Obtener un proyecto por su ID

- Método: GET
- URL: `http://localhost:8080/proyectos/{id}`
  - Reemplaza `{id}` con el ID del proyecto que deseas obtener rango(1.. 4).

#### 3. Crear un nuevo proyecto

- Método: POST
- URL: `http://localhost:8080/proyectos`
- Cuerpo de la solicitud (en formato JSON):

```json
{
    "nombre": "Nuevo proyecto",
    "descripcion": "Descripción del nuevo proyecto",
    "fecha_inicio": "2024-05-12",
    "fecha_fin": "2024-06-30",
    "activo": true
}
```

#### 4. Actualizar un proyecto existente

- Método: PUT
- URL: `http://localhost:8080/proyectos/{id}`
  - Reemplaza `{id}` con el ID del proyecto que deseas actualizar (1.. 4).
- Cuerpo de la solicitud (en formato JSON) con los campos que deseas actualizar:

```json
{
    "nombre": "Nombre actualizado",
    "descripcion": "Descripción actualizada",
    "fecha_inicio": "2023-01-01",
    "fecha_fin": "2024-02-02",
    "activo": false
}
```

#### 5. Eliminar un proyecto

- Método: DELETE
- URL: `http://localhost:8080/proyectos/{id}`
  - Reemplaza `{id}` con el ID del proyecto que deseas eliminar (1.. 4).
