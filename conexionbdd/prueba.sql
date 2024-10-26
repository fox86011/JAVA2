CREATE DATABASE INVENTARIOS_KRAKEDEV;

DROP TABLE IF EXISTS registro_movimientos;
DROP TABLE IF EXISTS articulos;
DROP TABLE IF EXISTS grupos;


CREATE TABLE grupos (
    codigo_grupo CHAR(3) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    estado BOOLEAN NOT NULL
);

CREATE TABLE articulos (
    codigo_articulo CHAR(5) PRIMARY KEY,
    codigo_grupo CHAR(3) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    precio MONEY NOT NULL,
    stock INT NOT NULL,
    estado BOOLEAN NOT NULL,
    FOREIGN KEY (codigo_grupo) REFERENCES grupos(codigo_grupo)
);


CREATE TABLE registro_movimientos (
    secuencial SERIAL PRIMARY KEY,
    codigo_articulo CHAR(5) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    tipo_movimiento CHAR(1) NOT NULL,
    cantidad INT NOT NULL,
    FOREIGN KEY (codigo_articulo) REFERENCES articulos(codigo_articulo)
);

INSERT INTO grupos VALUES 
('G01', 'Electrónica', true),
('G02', 'Ropa', true),
('G03', 'Alimentos', true);

INSERT INTO articulos VALUES
('ART01', 'G01', 'Smartphone', 500.00, 10, true),
('ART02', 'G01', 'Laptop', 1000.00, 5, true),
('ART03', 'G02', 'Camiseta', 20.00, 50, true),
('ART04', 'G02', 'Pantalón', 45.00, 30, true),
('ART05', 'G03', 'Arroz', 2.50, 100, true),
('ART06', 'G01', 'Tablet', 300.00, 15, true),
('ART07', 'G02', 'Zapatos', 60.00, 25, true),
('ART08', 'G03', 'Azúcar', 1.50, 200, true),
('ART09', 'G01', 'Audífonos', 25.00, 40, true),
('ART10', 'G02', 'Chaqueta', 80.00, 20, true);

INSERT INTO registro_movimientos (codigo_articulo, fecha, tipo_movimiento, cantidad) VALUES
('ART01', CURRENT_TIMESTAMP, 'I', 5),
('ART02', CURRENT_TIMESTAMP, 'S', 2),
('ART03', CURRENT_TIMESTAMP, 'I', 10),
('ART04', CURRENT_TIMESTAMP, 'S', 5),
('ART05', CURRENT_TIMESTAMP, 'I', 50),
('ART06', CURRENT_TIMESTAMP, 'S', 3),
('ART07', CURRENT_TIMESTAMP, 'I', 15),
('ART08', CURRENT_TIMESTAMP, 'S', 20),
('ART09', CURRENT_TIMESTAMP, 'I', 25),
('ART10', CURRENT_TIMESTAMP, 'S', 4);
