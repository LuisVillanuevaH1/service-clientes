DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
  id 				INT AUTO_INCREMENT PRIMARY KEY,
  nombre 			VARCHAR(100) NOT NULL,
  apellido 			VARCHAR(100) NOT NULL,
  fecha_nacimiento 	DATE NOT NULL
);