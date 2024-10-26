-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS RecursosHumanos;
USE RecursosHumanos;

-- Tabla GrupoFamiliar
CREATE TABLE IF NOT EXISTS GrupoFamiliar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rol VARCHAR(20) NOT NULL
);

-- Tabla Funcionario
CREATE TABLE IF NOT EXISTS Funcionario (
    numero_id VARCHAR(20) PRIMARY KEY,
    grupo_familiar_id INT,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    estado_civil VARCHAR(20),
    sexo VARCHAR(10),
    direccion VARCHAR(100),
    telefono VARCHAR(15),
    fecha_nacimiento DATE,
    FOREIGN KEY (grupo_familiar_id) REFERENCES GrupoFamiliar(id)
);

-- Tabla MiembroFamiliar
CREATE TABLE IF NOT EXISTS MiembroFamiliar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    grupo_familiar_id INT,
    nombre VARCHAR(50) NOT NULL,
    parentesco VARCHAR(20),
    edad INT,
    FOREIGN KEY (grupo_familiar_id) REFERENCES GrupoFamiliar(id)
);

-- Tabla InformacionAcademica
CREATE TABLE IF NOT EXISTS InformacionAcademica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    funcionario_id VARCHAR(20),
    universidad VARCHAR(100) NOT NULL,
    nivel_estudio VARCHAR(50) NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    FOREIGN KEY (funcionario_id) REFERENCES Funcionario(numero_id)
);


-- Insertar en GrupoFamiliar
INSERT INTO GrupoFamiliar (rol) VALUES
('Padre/Madre'),
('Hijo/a'),
('Esposo/a');


-- Insertar en Funcionario
INSERT INTO Funcionario (numero_id, grupo_familiar_id, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento) VALUES
('123456789', 1, 'Juan', 'Perez', 'Casado', 'M', 'Calle Falsa 123', '555-1234', '1980-01-01'),
('987654321', 2, 'Maria', 'Gomez', 'Soltera', 'F', 'Avenida Siempre Viva 742', '555-5678', '1990-02-15');

-- Insertar en MiembroFamiliar
INSERT INTO MiembroFamiliar (grupo_familiar_id, nombre, parentesco, edad) VALUES
(1, 'Luis Perez', 'Hijo', 10),
(1, 'Ana Perez', 'Hija', 8),
(2, 'Carlos Gomez', 'Esposo', 30);

-- Insertar en InformacionAcademica
INSERT INTO InformacionAcademica (funcionario_id, universidad, nivel_estudio, titulo) VALUES
('123456789', 'Universidad de Antioquia', 'Pregrado', 'Ingeniería'),
('123456789', 'Universidad Nacional', 'Maestría', 'Ingeniería de Sistemas'),
('987654321', 'Universidad EAFIT', 'Pregrado', 'Administración de Empresas');
