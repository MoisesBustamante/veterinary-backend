CREATE EXTENSION IF NOT EXISTS "pgcrypto";

DROP TABLE IF EXISTS ciudad CASCADE;
DROP TABLE IF EXISTS propietarios CASCADE;
DROP TABLE IF EXISTS pacientes CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE ciudad (
    id_ciudad VARCHAR(50) PRIMARY KEY,
    nombre_ciudad VARCHAR(100) NOT NULL
);
CREATE TABLE propietarios (
    id_dueno VARCHAR(50) PRIMARY KEY,
    tipo_identificacion VARCHAR(10) NOT NULL,
    identificacion_dueno VARCHAR(20) NOT NULL,
    nombre_dueno VARCHAR(100) NOT NULL,
    id_ciudad VARCHAR(50) REFERENCES ciudad(id_ciudad),
    direccion VARCHAR(200),
    telefono VARCHAR(20)
);


CREATE TABLE pacientes (
    id_mascota VARCHAR(50) PRIMARY KEY,
    nombre_mascota VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raza VARCHAR(50),
    fecha_nacimiento DATE,
    id_dueno VARCHAR(50) REFERENCES propietarios(id_dueno)
);
CREATE TABLE users (
    id_user VARCHAR(50) PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
