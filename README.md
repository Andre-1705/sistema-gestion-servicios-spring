# 🚀 Servicios Integrales - Versión Mejorada

## 📋 Descripción
Sistema de gestión integral para servicios de programación y comunicación, desarrollado con Spring Boot y PostgreSQL.

## ✨ Características Principales

### 🎨 **Frontend Moderno**
- Diseño responsive con Bootstrap 5
- Animaciones y efectos visuales
- Interfaz intuitiva y profesional
- Iconos de Font Awesome

### 🗄️ **Base de Datos**
- PostgreSQL como base de datos principal
- JPA/Hibernate para mapeo de objetos
- Spring Data JPA para operaciones CRUD
- Esquema optimizado con restricciones

### 🔧 **Tecnologías Utilizadas**
- **Backend**: Spring Boot 3.2.6
- **Base de Datos**: PostgreSQL
- **Frontend**: Thymeleaf + Bootstrap 5
- **ORM**: Spring Data JPA
- **Java**: JDK 17

## 🏗️ Estructura del Proyecto

```
Servicios/
├── src/main/java/
│   └── ar/org/centro8/curso/tp3/servicios/
│       ├── controllers/     # Controladores REST
│       ├── entities/        # Entidades JPA
│       ├── repositories/    # Repositorios Spring Data
│       └── ServiciosApplication.java
├── src/main/resources/
│   ├── templates/          # Plantillas Thymeleaf
│   ├── static/            # Archivos estáticos (CSS, JS, imágenes)
│   ├── sql/              # Scripts SQL
│   └── application.properties
└── pom.xml
```

## 🚀 Instalación y Configuración

### Prerrequisitos
- Java 17 o superior
- PostgreSQL 12 o superior
- Maven 3.6+

### 1. Clonar el repositorio
```bash
git clone [URL_DEL_REPOSITORIO]
cd Servicios
```

### 2. Configurar PostgreSQL
```sql
-- Crear base de datos
CREATE DATABASE servicios;

-- Ejecutar script DDL
\i src/main/resources/sql/DDL_postgresql.sql
```

### 3. Configurar aplicación
Editar `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/servicios
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
```

### 4. Ejecutar la aplicación
```bash
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8084`

## 📱 Funcionalidades

### 👥 **Gestión de Clientes**
- Agregar, editar y eliminar clientes
- Búsqueda por nombre o apellido
- Validación de datos en tiempo real

### ⚙️ **Gestión de Servicios**
- Crear servicios de Programación y Comunicación
- Asignar servicios a clientes
- Categorización por tipo

### 📦 **Gestión de Productos**
- Control de inventario
- Precios y stock
- Búsqueda avanzada

### 👨‍💼 **Gestión de Empleados**
- Registro de empleados
- Control de salarios
- Fechas de contrato

## 🎯 Mejoras Implementadas

### ✅ **Versión Anterior vs Actual**
- **Antes**: JDBC directo, MySQL, frontend básico
- **Ahora**: JPA, PostgreSQL, frontend moderno

### 🔄 **Migración de Tecnologías**
- JDBC → Spring Data JPA
- MySQL → PostgreSQL
- HTML básico → Bootstrap 5 + Thymeleaf
- Sin validaciones → Validaciones completas

## 📊 Base de Datos

### Tablas Principales
- **clientes**: Información de clientes
- **servicios**: Servicios ofrecidos
- **productos**: Inventario de productos
- **empleados**: Personal de la empresa

### Relaciones
- Servicios → Clientes (Many-to-One)
- Productos independientes
- Empleados independientes

## 🛠️ Desarrollo

### Compilar
```bash
mvn clean compile
```

### Ejecutar tests
```bash
mvn test
```

### Empaquetar
```bash
mvn clean package
```

## 📝 Licencia
Este proyecto es parte del curso de programación y está destinado únicamente para fines educativos.

## 👨‍💻 Autor
Desarrollado como proyecto académico para gestión de servicios integrales.

---
**Versión**: 2.0 - Mejorada con Spring Boot y PostgreSQL
**Fecha**: Junio 2025
