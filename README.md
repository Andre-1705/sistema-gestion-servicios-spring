# Sistema de Gestión de Servicios - Spring Boot

## 📋 Descripción
Sistema web completo para la gestión de servicios, clientes, empleados y productos desarrollado con Spring Boot. La aplicación proporciona una interfaz moderna y responsive para administrar todos los aspectos de un negocio de servicios.

## 🚀 Tecnologías Utilizadas
- **Backend:** Spring Boot 3.2.6
- **Frontend:** Thymeleaf, Bootstrap 5, Font Awesome
- **Base de Datos:** PostgreSQL
- **Build Tool:** Maven
- **Java:** JDK 21

## ✨ Características
- 🏠 **Página Principal:** Dashboard con estadísticas y navegación intuitiva
- 👥 **Gestión de Clientes:** CRUD completo para clientes
- 🔧 **Gestión de Servicios:** Administración de servicios ofrecidos
- 👨‍💼 **Gestión de Empleados:** Control de personal
- 📦 **Gestión de Productos:** Inventario de productos
- ⚙️ **Configuración:** Panel de configuración del sistema
- 📱 **Responsive Design:** Adaptable a móviles, tablets y desktop
- 🎨 **UI Moderna:** Interfaz con animaciones y efectos visuales

## 🛠️ Instalación y Configuración

### Prerrequisitos
- Java 21 o superior
- Maven 3.6+
- PostgreSQL (para producción)

### Pasos de Instalación
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/Andre-1705/sistema-gestion-servicios-spring.git
   cd sistema-gestion-servicios-spring
   ```

2. **Compilar el proyecto:**
   ```bash
   ./mvnw clean install
   ```

3. **Ejecutar la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acceder a la aplicación:**
   - URL: http://localhost:8084
   - La aplicación se ejecuta en el puerto 8084

## 📁 Estructura del Proyecto
```
src/
├── main/
│   ├── java/
│   │   └── ar/org/centro8/curso/tp3/servicios/
│   │       ├── controllers/     # Controladores REST
│   │       ├── entities/        # Entidades JPA
│   │       ├── repositories/    # Repositorios de datos
│   │       ├── connectors/      # Conectores de base de datos
│   │       └── utils/           # Utilidades
│   └── resources/
│       ├── templates/           # Plantillas Thymeleaf
│       ├── static/              # CSS, JS, imágenes
│       ├── sql/                 # Scripts de base de datos
│       └── application.properties
```

## 🎯 Funcionalidades Principales

### Dashboard Principal
- Vista general del sistema
- Navegación intuitiva
- Diseño responsive

### Gestión de Clientes
- Listado de clientes
- Agregar nuevos clientes
- Editar información existente
- Eliminar clientes

### Gestión de Servicios
- Catálogo de servicios
- Administración de precios
- Control de disponibilidad

### Panel de Configuración
- Configuración del sistema
- Ajustes de aplicación

## 🔧 Configuración de Base de Datos
La aplicación está configurada para usar PostgreSQL. Los scripts SQL se encuentran en `src/main/resources/sql/`:
- `DDL.sql` - Estructura de la base de datos
- `DML.sql` - Datos de ejemplo
- `Query.sql` - Consultas de ejemplo

## 📱 Capturas de Pantalla
*[Aquí puedes agregar capturas de pantalla de la aplicación]*

## 🤝 Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue o pull request para sugerencias y mejoras.

## 📄 Licencia
Este proyecto está bajo la Licencia MIT.

## 👨‍💻 Autor
Desarrollado por [Tu Nombre] como proyecto de Spring Boot.

---
⭐ Si te gusta este proyecto, ¡dale una estrella en GitHub!
