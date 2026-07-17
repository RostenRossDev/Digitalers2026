
USE comercioit;

CREATE TABLE PRODUCTOS(
                          idProducto INT(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          Nombre VARCHAR(50) NOT NULL,
                          Precio DOUBLE,
                          Marca VARCHAR(30) NOT NULL,
                          Categoria VARCHAR(30) NOT NULL,
                          Stock INT(6) NOT NULL,
                          Disponible BOOLEAN DEFAULT false
);


#Elimina la tabla si es que existe, sino puede al menos no falla

-- Esto es un comentario de 1 línea

/* Esto es un comentario de 1
 *
 *
 *
 *
 *  o más líneas */

DROP TABLE IF EXISTS Productos;

SHOW databases

SHOW TABLES

DESCRIBE productos;
SHOW CHARSET
SHOW collation

CREATE TABLE Medida (medida ENUM('pequeño', 'mediano', 'grande') NOT NULL DEFAULT 'mediano');



select * from comercioit.medida m
select * from comercioit.letra m

    INSERT INTO comercioit.medida (medida) VALUES('pequeño');



CREATE TABLE comercioit.Letra (letra SET('a', 'b', 'c', 'd'));
INSERT INTO comercioit.Letra (letra) VALUES('a');
INSERT INTO comercioit.Letra (letra) VALUES('a,c,d');
INSERT INTO comercioit.Letra (letra) VALUES('a,c,d,a,b');


CREATE TABLE PRODUCTOS(
                          idProducto INT(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          Nombre VARCHAR(50) NOT NULL,
                          Precio DOUBLE,
                          Marca VARCHAR(30) NOT NULL,
                          Categoria VARCHAR(30) NOT NULL,
                          Stock INT(6) NOT NULL,
                          Disponible BOOLEAN DEFAULT false
);


INSERT INTO comercioit.productos
(Nombre, Precio, Marca, Categoria, Stock, Disponible)
VALUES('Monitor', 100, 'asdas', 'asdsa', 25, 1);


select * from productos p


SELECT *, Precio * 1.25 as 'Precio con Aumento' FROM productos;

SELECT *, 'China' as Origen FROM productos;


-- SELECT nombre, apellido FROM clientes ORDER BY apellido; -- ASC
-- select nombre, marca from productos p  -> esto me trae resultados


select * from productos p -- Trae todos los regustros con todas sus columnas

select p.idProducto, nombre, marca from productos p order by nombre desc -- Ordenar por columnas varias y trae todos los registros pero solo sus columnas idProducto, nombre y marca.

select p.idProducto, nombre, marca from productos p order by nombre DESC, marca asc LIMIT 2  -- Lo mismo que el anterior pero con un limite de 2 elementos (los primeros)

select * from productos p limit 2 OFFSET 2


--########################################
drop table if EXISTS comercioit.letra
drop table if EXISTS comercioit.medida

drop table if EXISTS comercioit.FACTURAS
drop table if EXISTS comercioit.ARTICULOS
drop table if EXISTS comercioit.CLIENTES
drop table if EXISTS comercioit.DETALLES

--- ############################################################ comercio it

CREATE TABLE IF NOT EXISTS `FACTURAS` (
                                          `FACTURA_ID` int AUTO_INCREMENT NOT NULL,
                                          `LETRA` char(1) NOT NULL,
    `NUMERO` int NOT NULL UNIQUE,
    `CLIENTE_ID` int NOT NULL,
    `FECHA` date NOT NULL,
    `MONTO` DECIMAL(12,2) NOT NULL,
    `FECHA_CREACION` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `FECHA_MODIFICACION` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`FACTURA_ID`)
    );
CREATE TABLE IF NOT EXISTS `ARTICULOS` (
                                           `ARTICULO_ID` int AUTO_INCREMENT NOT NULL,
                                           `NOMBRE` varchar(50) NOT NULL,
    `PRECIO` DECIMAL(12,2) NOT NULL DEFAULT 0,
    `STOCK` int NOT NULL DEFAULT 0,
    `FECHA_CREACION` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `FECHA_MODIFICACION` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`ARTICULO_ID`)
    );
CREATE TABLE IF NOT EXISTS `CLIENTES` (
                                          `CLIENTE_ID` int AUTO_INCREMENT NOT NULL,
                                          `NOMBRE` varchar(50) NOT NULL,
    `APELLIDO` varchar(50) NOT NULL,
    `CUIT` char(11) NOT NULL,
    `DIRECCION` varchar(50) NOT NULL,
    `COMENTARIO` TEXT NOT NULL,
    `FECHA_CREACION` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `FECHA_MODIFICACION` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`CLIENTE_ID`)
    );
CREATE TABLE IF NOT EXISTS `DETALLES` (
                                          `DETALLE_ID` int AUTO_INCREMENT NOT NULL,
                                          `ARTICULO_ID` int NOT NULL,
                                          `FACTURA_ID` int NOT NULL,
                                          `PRECIO_UNITARIO` DECIMAL(12,2) NOT NULL,
    `CANTIDAD` int NOT NULL,
    `SUB_TOTAL` DECIMAL(12,2) GENERATED ALWAYS AS (CANTIDAD * PRECIO_UNITARIO) STORED,
    `FECHA_CREACION` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `FECHA_MODIFICACION` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`DETALLE_ID`)
    );

CREATE INDEX `idx_fecha` ON `FACTURAS` (`FECHA`);

CREATE INDEX `idx_apellido` ON `CLIENTES` (`APELLIDO`);

ALTER TABLE `FACTURAS` ADD CONSTRAINT `FACTURAS_fk3` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `CLIENTES`(`CLIENTE_ID`) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE `DETALLES` ADD CONSTRAINT `DETALLES_fk1` FOREIGN KEY (`ARTICULO_ID`) REFERENCES `ARTICULOS`(`ARTICULO_ID`) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE `DETALLES` ADD CONSTRAINT `DETALLES_fk2` FOREIGN KEY (`FACTURA_ID`) REFERENCES `FACTURAS`(`FACTURA_ID`) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE `DETALLES` ADD CONSTRAINT `chk_cantidad` CHECK (`CANTIDAD` > 0);

ALTER TABLE `ARTICULOS` ADD CONSTRAINT `chk_stock` CHECK (`STOCK` >= 0);


ALTER TABLE ARTICULOS ADD COLUMN OBSERVACIONES VARCHAR(50) NULL;


ALTER TABLE clientes ADD COLUMN Primera VARCHAR(50) NULL FIRST;

ALTER TABLE clientes ADD COLUMN Siguiente VARCHAR(50) NULL AFTER COMENTARIO;

ALTER TABLE articulos
    CHANGE OBSERVACIONES COMENTARIOS VARCHAR(40) NULL;

ALTER TABLE articulos MODIFY COMENTARIOS TEXT NULL;

ALTER TABLE clientes DROP COLUMN Primera;
ALTER TABLE clientes DROP COLUMN Siguiente;

ALTER TABLE clientes DROP COLUMN Primera, DROP COLUMN Siguiente;

ALTER TABLE ARTICULOS RENAME PRODUCTOS;
RENAME TABLE ARTICULOS TO PRODUCTOS;

ALTER TABLE PRODUCTOS DROP Primary Key;
ALTER TABLE Articulos ADD Primary Key(ArticuloID);

ALTER TABLE detalles DROP FOREIGN KEY DETALLES_fk1;
ALTER TABLE detalles ADD CONSTRAINT DETALLES_fk1 FOREIGN KEY(ARTICULO_ID) REFERENCES PRODUCTOS(ARTICULO_ID);

select * from articulos

select * from PRODUCTOS

select * from clientes


-- ####################################

-- =============================================
-- 0. Limpieza inicial
-- =============================================
    SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE DETALLES;
TRUNCATE TABLE FACTURAS;
TRUNCATE TABLE ARTICULOS;
TRUNCATE TABLE CLIENTES;
SET FOREIGN_KEY_CHECKS = 1;





-- =============================================
-- 1. Insertar 40 CLIENTES (explícitos)
-- =============================================
INSERT INTO CLIENTES (NOMBRE, APELLIDO, CUIT, DIRECCION, COMENTARIO) VALUES
                                                                         ('Juan', 'Perez', '20123456789', 'Av. Siempre Viva 123', 'Cliente habitual'),
                                                                         ('Maria', 'Gomez', '27345678901', 'Calle Falsa 456', 'Contacto por email'),
                                                                         ('Carlos', 'Lopez', '30567890123', 'Paseo de la Reforma 789', 'Empresa certificada'),
                                                                         ('Laura', 'Fernandez', '20567890123', 'Calle 10 #20-30', 'Referido por Juan'),
                                                                         ('Ana', 'Garcia', '27567890123', 'Av. Principal 456', 'Cliente VIP'),
                                                                         ('Luis', 'Martinez', '31567890123', 'Carrera 7 #45-67', 'Pago contado'),
                                                                         ('Marta', 'Rodriguez', '22567890123', 'Calle 20 #30-40', 'Descuento especial'),
                                                                         ('Jose', 'Gonzalez', '23567890123', 'Av. Libertador 789', 'Cliente frecuente'),
                                                                         ('Sofia', 'Sanchez', '24567890123', 'Calle 80 #10-20', 'Referido por Maria'),
                                                                         ('Pedro', 'Ramirez', '25567890123', 'Carrera 15 #60-70', 'Pago electrónico'),
                                                                         ('Claudia', 'Torres', '26567890123', 'Av. Corrientes 100', 'Cliente ocasional'),
                                                                         ('Ricardo', 'Mendoza', '27567890123', 'Calle 50 #12-34', 'Compra mensual'),
                                                                         ('Diana', 'Flores', '28567890123', 'Carrera 9 #80-90', 'Descuento por volumen'),
                                                                         ('Alberto', 'Reyes', '29567890123', 'Av. Independencia 200', 'Cliente antiguo'),
                                                                         ('Rosa', 'Ortiz', '30567890123', 'Calle 30 #56-78', 'Pago en efectivo'),
                                                                         ('Fernando', 'Diaz', '31567890123', 'Carrera 4 #90-100', 'Factura electrónica'),
                                                                         ('Lucia', 'Alvarez', '32567890123', 'Av. Rivadavia 500', 'Cliente preferencial'),
                                                                         ('Martin', 'Castillo', '33567890123', 'Calle 60 #23-45', 'Compra por mayor'),
                                                                         ('Paula', 'Romero', '34567890123', 'Carrera 12 #34-56', 'Referido por Carlos'),
                                                                         ('Andres', 'Molina', '35567890123', 'Av. Belgrano 150', 'Cliente nuevo'),
                                                                         ('Florencia', 'Morales', '36567890123', 'Calle 70 #45-67', 'Pago con tarjeta'),
                                                                         ('Gabriel', 'Ortega', '37567890123', 'Carrera 8 #11-22', 'Descuento por fidelidad'),
                                                                         ('Valeria', 'Vargas', '38567890123', 'Av. San Martin 300', 'Cliente de larga data'),
                                                                         ('Damian', 'Ramos', '39567890123', 'Calle 90 #33-44', 'Requiere factura A'),
                                                                         ('Silvana', 'Guerrero', '40567890123', 'Carrera 5 #77-88', 'Pago a 30 días'),
                                                                         ('Hector', 'Soto', '41567890123', 'Av. Quintana 600', 'Cliente de referencia'),
                                                                         ('Camila', 'Jimenez', '42567890123', 'Calle 40 #10-20', 'Solicita presupuesto'),
                                                                         ('Emiliano', 'Ruiz', '43567890123', 'Carrera 3 #55-66', 'Compra semanal'),
                                                                         ('Daniela', 'Chavez', '44567890123', 'Av. Cordoba 800', 'Cliente con descuento'),
                                                                         ('Patricio', 'Gutierrez', '45567890123', 'Calle 100 #22-33', 'Pago mixto'),
                                                                         ('Victoria', 'Palacios', '46567890123', 'Carrera 6 #44-55', 'Referido por Sofia'),
                                                                         ('Raul', 'Mendez', '47567890123', 'Av. Santa Fe 700', 'Cliente corporativo'),
                                                                         ('Guadalupe', 'Alonso', '48567890123', 'Calle 110 #11-22', 'Factura electrónica'),
                                                                         ('Mauricio', 'Cruz', '49567890123', 'Carrera 2 #33-44', 'Pago en línea'),
                                                                         ('Miriam', 'Navarro', '50567890123', 'Av. Callao 400', 'Cliente frecuente'),
                                                                         ('Joaquin', 'Silva', '51567890123', 'Calle 120 #55-66', 'Descuento por pronto pago'),
                                                                         ('Liliana', 'Espinoza', '52567890123', 'Carrera 1 #77-88', 'Referido por Andres'),
                                                                         ('Esteban', 'Munoz', '53567890123', 'Av. Pueyrredon 900', 'Cliente mayorista'),
                                                                         ('Alicia', 'Salazar', '54567890123', 'Calle 130 #99-00', 'Compra mensual fija'),
                                                                         ('Ivan', 'Medina', '55567890123', 'Carrera 11 #12-34', 'Cliente habitual');


-- =============================================
-- 2. Insertar 60 ARTICULOS (explícitos)
-- =============================================
INSERT INTO ARTICULOS (NOMBRE, PRECIO, STOCK) VALUES
                                                  ('Laptop HP 15"', 750000.00, 10),
                                                  ('Mouse Logitech', 15000.00, 50),
                                                  ('Teclado Mecánico', 45000.00, 20),
                                                  ('Monitor Samsung 24"', 180000.00, 5),
                                                  ('Auriculares Sony', 55000.00, 15),
                                                  ('Disco SSD 1TB', 120000.00, 8),
                                                  ('Memoria RAM 16GB', 40000.00, 30),
                                                  ('Gabinete ATX', 85000.00, 12),
                                                  ('Fuente 750W', 65000.00, 18),
                                                  ('Placa Madre B550', 110000.00, 7),
                                                  ('Procesador Intel i7', 320000.00, 4),
                                                  ('Procesador AMD Ryzen 5', 280000.00, 6),
                                                  ('Placa de Video RTX 3060', 550000.00, 3),
                                                  ('Cooler CPU', 12000.00, 40),
                                                  ('Router WiFi 6', 38000.00, 25),
                                                  ('Switch de red 8 puertos', 45000.00, 10),
                                                  ('Cable HDMI 2m', 3500.00, 100),
                                                  ('Cable USB-C', 2500.00, 150),
                                                  ('Pendrive 64GB', 8000.00, 60),
                                                  ('Disco Duro Externo 2TB', 95000.00, 9),
                                                  ('Tablet Samsung', 200000.00, 6),
                                                  ('Smartphone Xiaomi', 180000.00, 12),
                                                  ('Smart TV 55"', 420000.00, 4),
                                                  ('Proyector Epson', 300000.00, 2),
                                                  ('Impresora Laser', 130000.00, 5),
                                                  ('Tinta Negra', 12000.00, 20),
                                                  ('Tinta Color', 15000.00, 15),
                                                  ('Papel A4 500 hojas', 6000.00, 80),
                                                  ('Carpeta de archivo', 1000.00, 200),
                                                  ('Lapicera BIC', 500.00, 500),
                                                  ('Cuaderno espiral', 2000.00, 100),
                                                  ('Marcador permanente', 800.00, 150),
                                                  ('Borrador de pizarra', 400.00, 120),
                                                  ('Resaltador', 700.00, 90),
                                                  ('Tijera de oficina', 2500.00, 40),
                                                  ('Cutter', 1500.00, 50),
                                                  ('Cinta adhesiva', 2000.00, 70),
                                                  ('Grapadora', 3500.00, 25),
                                                  ('Perforadora', 4500.00, 20),
                                                  ('Calculadora científica', 18000.00, 10),
                                                  ('Regla de 30cm', 1500.00, 60),
                                                  ('Escuadra', 2000.00, 50),
                                                  ('Compás', 3000.00, 30),
                                                  ('Transportador', 2500.00, 25),
                                                  ('Lapiz HB', 300.00, 300),
                                                  ('Goma de borrar', 200.00, 400),
                                                  ('Sacapuntas', 400.00, 200),
                                                  ('Caja de lápices de color', 12000.00, 15),
                                                  ('Acuarelas', 15000.00, 8),
                                                  ('Pincel redondo', 1000.00, 50),
                                                  ('Lienzo para pintar', 8000.00, 12),
                                                  ('Yeso artístico', 5000.00, 20),
                                                  ('Arcilla', 6000.00, 10),
                                                  ('Tiza pastel', 7000.00, 8),
                                                  ('Cuchilla de modelado', 2500.00, 15),
                                                  ('Base para escultura', 18000.00, 4),
                                                  ('Vaso precipitado 500ml', 4000.00, 30),
                                                  ('Tubo de ensayo', 800.00, 100),
                                                  ('Gradilla', 2500.00, 20),
                                                  ('Microscopio escolar', 250000.00, 2);


INSERT INTO FACTURAS (NUMERO, LETRA, CLIENTE_ID, FECHA, MONTO)
SELECT
    ROW_NUMBER() OVER (ORDER BY c.CLIENTE_ID, n.n) + 1000 AS NUMERO,
    ELT(1 + FLOOR(RAND() * 3), 'A', 'B', 'C') AS LETRA,
    c.CLIENTE_ID,
    DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND() * 180) DAY) AS FECHA,
    0.00 AS MONTO
FROM CLIENTES c
         CROSS JOIN (
    SELECT 1 n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
    SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
    SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14
) n
WHERE n.n <= 10 + (c.CLIENTE_ID % 5)   -- 10 a 14 facturas por cliente
ORDER BY c.CLIENTE_ID, n.n;


-- =============================================
-- 4. Generar DETALLES (entre 1 y 5 por factura)
-- =============================================
INSERT INTO DETALLES (ARTICULO_ID, FACTURA_ID, PRECIO_UNITARIO, CANTIDAD)
SELECT
    a.ARTICULO_ID,
    f.FACTURA_ID,
    a.PRECIO,
    1 + FLOOR(RAND() * 10) AS CANTIDAD
FROM FACTURAS f
         CROSS JOIN (
    SELECT 1 n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5
) d
         JOIN ARTICULOS a ON a.ARTICULO_ID = 1 + FLOOR(RAND() * 60)
WHERE d.n <= 1 + (f.FACTURA_ID % 5)   -- 1 a 5 detalles
ORDER BY f.FACTURA_ID, RAND();

-- =============================================
-- 5. Actualizar el MONTO de cada factura
-- =============================================
UPDATE FACTURAS f
SET f.MONTO = (
    SELECT COALESCE(SUM(d.SUB_TOTAL), 0)
    FROM DETALLES d
    WHERE d.FACTURA_ID = f.FACTURA_ID
);


-- =============================================
-- Verificación final
-- =============================================
SELECT
    (SELECT COUNT(*) FROM CLIENTES) AS Clientes,
    (SELECT COUNT(*) FROM ARTICULOS) AS Articulos,
    (SELECT COUNT(*) FROM FACTURAS) AS Facturas,
    (SELECT COUNT(*) FROM DETALLES) AS Detalles;
