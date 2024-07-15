CREATE DATABASE hospital;

CREATE TABLE doctor (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido_paterno VARCHAR(255) NOT NULL,
    apellido_materno VARCHAR(255) NOT NULL,
    especialidad VARCHAR(255) NOT NULL
);

CREATE TABLE consultorio (
    id SERIAL PRIMARY KEY,
    numero_consultorio VARCHAR(255) NOT NULL,
    piso VARCHAR(255) NOT NULL
);

CREATE TABLE cita (
    id SERIAL PRIMARY KEY,
    consultorio_id INT NOT NULL,
    doctor_id INT NOT NULL,
    horario_consulta TIMESTAMP NOT NULL,
    nombre_paciente VARCHAR(255) NOT NULL,
    CONSTRAINT fk_consultorio FOREIGN KEY (consultorio_id) REFERENCES consultorio(id),
    CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(id)
);

-- Inserciones en la tabla 'doctor'
INSERT INTO doctor (nombre, apellido_paterno, apellido_materno, especialidad)
VALUES 
('Juan', 'Perez', 'Gomez', 'Cardiología'),
('Ana', 'Martinez', 'Lopez', 'Neurología'),
('Carlos', 'Sanchez', 'Torres', 'Pediatría');

-- Inserciones en la tabla 'consultorio'
INSERT INTO consultorio (numero_consultorio, piso)
VALUES 
('101', '1'),
('202', '2'),
('303', '3');

