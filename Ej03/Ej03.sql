-- Crear tabla productos
CREATE TABLE `jwa-ej03`.productos (
	id INT NOT NULL,
	nombre varchar(100) NULL,
	descripcion varchar(100) NULL,
	precio NUMERIC NULL,
	CONSTRAINT productos_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;


-- Insertar datos
INSERT INTO `jwa-ej03`.productos
(id, nombre, descripcion, precio)
VALUES(1, 'Mouse', 'Logitech muy bueno', 154.4);

INSERT INTO `jwa-ej03`.productos
(id, nombre, descripcion, precio)
VALUES(2, 'Teclado', 'Un teclado bueno', 546.4);

INSERT INTO `jwa-ej03`.productos
(id, nombre, descripcion, precio)
VALUES(3, 'Monitor', 'LG 32 pulgadas', 1504.4);



-- consultar
select * from productos p ;
