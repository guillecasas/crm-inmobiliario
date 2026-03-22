# 🏢 CRM Inmobiliario

Aplicación backend desarrollada con **Java y Spring Boot** para la gestión de clientes, propiedades e intereses en un entorno inmobiliario real.

Este proyecto simula el funcionamiento de un CRM utilizado por una agencia inmobiliaria, aplicando una arquitectura en capas y buenas prácticas de desarrollo backend.

---

## 🚀 Tecnologías utilizadas

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- REST API

---

## 📦 Funcionalidades

### 👤 Clientes
- Crear clientes
- Consultar clientes

### 🏠 Propiedades
- Crear propiedades
- Consultar propiedades
- Filtrar propiedades por:
    - Estado (disponible, reservado…)
    - Tipo (piso, casa, oficina…)
    - Precio máximo

### 🔗 Intereses
- Registrar interés de un cliente en una propiedad
- Relación entre cliente y propiedad
- Registro de fecha de contacto y comentarios

---

## 🧱 Arquitectura del proyecto

El proyecto sigue una arquitectura en capas:

- `controller` → gestión de endpoints REST
- `service` → lógica de negocio
- `repository` → acceso a base de datos (JPA)
- `model` → entidades del dominio
- `dto` → objetos de transferencia de datos

---

## 🔗 Endpoints principales

### Clientes
- `GET /clientes`
- `POST /clientes`

### Propiedades
- `GET /propiedades`
- `POST /propiedades`
- `GET /propiedades/estado/{estado}`
- `GET /propiedades/tipo/{tipo}`
- `GET /propiedades/precio-max/{precio}`

### Intereses
- `GET /intereses`
- `POST /intereses`

---

## 🧪 Ejemplo de uso

### Crear un interés

```json
{
  "clienteId": 1,
  "propiedadId": 1,
  "fechaContacto": "2026-03-22",
  "comentario": "Cliente interesado en visitar la propiedad"
}