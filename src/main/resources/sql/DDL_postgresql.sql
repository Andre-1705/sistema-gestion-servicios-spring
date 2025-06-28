-- Script DDL para PostgreSQL
-- Crear base de datos (ejecutar como superusuario)

-- Conectar a la base de datos servicios
\c servicios;

-- Eliminar tablas si existen
DROP TABLE IF EXISTS servicios CASCADE;
DROP TABLE IF EXISTS productos CASCADE;
DROP TABLE IF EXISTS empleados CASCADE;
DROP TABLE IF EXISTS clientes CASCADE;

-- Crear tabla clientes
CREATE TABLE clientes(
    id SERIAL PRIMARY KEY,
    apellido VARCHAR(25) NOT NULL CHECK(length(apellido)>=2),
    nombre VARCHAR(25) NOT NULL CHECK(length(nombre)>=2),  
    edad INTEGER NOT NULL CHECK(edad>=18 AND edad<=120),
    email VARCHAR(50) NOT NULL,
    telefono VARCHAR(25),
    activo BOOLEAN DEFAULT true
);

-- Crear tabla servicios
CREATE TABLE servicios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200),
    tipo VARCHAR(50) NOT NULL CHECK(tipo IN('Programacion', 'Comunicacion')),
    cliente_id INTEGER,
    activo BOOLEAN DEFAULT true,
    CONSTRAINT FK_Servicios_Clientes
        FOREIGN KEY (cliente_id) 
        REFERENCES clientes(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

-- Crear tabla productos
CREATE TABLE productos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    precio DOUBLE PRECISION NOT NULL,
    stock INTEGER NOT NULL,
    activo BOOLEAN DEFAULT true
);

-- Crear tabla empleados
CREATE TABLE empleados (
    id SERIAL PRIMARY KEY,
    apellido VARCHAR(25) NOT NULL CHECK(length(apellido)>=2), 
    nombre VARCHAR(25) NOT NULL,
    salario DOUBLE PRECISION NOT NULL,
    fecha_contrato DATE NOT NULL,
    activo BOOLEAN DEFAULT true
); 