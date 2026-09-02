
use universidad

CREATE TABLE IF NOT EXISTS `PERSONAS` (
                                          `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                          `NOMBRE` varchar(50) NOT NULL,
    `APELLIDO` int NOT NULL,
    `DOCUMENTO` varchar(8) NOT NULL,
    `DIRECCION` varchar(50) NOT NULL,
    `TELEFONO` varchar(10) NOT NULL,
    `CORREO` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `EMPLEADO` (
                                          `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                          `PERSONA_FK` int NOT NULL,
                                          `LEGAJO` int NOT NULL,
                                          `FECHA_INGRESO` timestamp NOT NULL,
                                          PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `ESTUDIANTE` (
                                            `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                            `PERSONA_FK` int NOT NULL,
                                            `LEGAJO` int NOT NULL,
                                            PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `DECANO` (
                                        `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                        `EMPLEADO_FK` int NOT NULL,
                                        `FECHA_INICIO` timestamp NOT NULL COMMENT 'FECHA EN LA QUE COMENZO CON EL CARGO DE DECANO',
                                        PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `DOCENTE` (
                                         `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                         `EMPLEADO_FK` int NOT NULL,
                                         PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `MAESTRANZA` (
                                            `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                            `EMPLEADO_ID` int NOT NULL,
                                            `HORA_INGRESO` varchar(20) NOT NULL,
    `HORA_SALIDA` varchar(20) NOT NULL,
    PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `CARRERA` (
                                         `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                         `NOMBRE` varchar(255) NOT NULL,
    `FACULTAD_FK` int NOT NULL,
    PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `MATERIA` (
                                         `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                         `NOMBRE` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `CURSO` (
                                       `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                       `FECHA` varchar(4) NOT NULL,
    `DOCENTE_FK` int NOT NULL,
    `MATERIA_FK` int NOT NULL,
    `ESTUDIANTE_FK` int NOT NULL,
    `CARRERA_FK` int NOT NULL,
    `AULA_FK` int NOT NULL,
    PRIMARY KEY (`id`)
    );
CREATE TABLE IF NOT EXISTS `AULA` (
                                      `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                      `NUMERO_AULA` int NOT NULL,
                                      PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `FACULTAD` (
                                          `id` int AUTO_INCREMENT NOT NULL UNIQUE,
                                          `NOMBRE` varchar(50) NOT NULL
    )



ALTER TABLE `EMPLEADO` ADD CONSTRAINT `EMPLEADO_fk1` FOREIGN KEY (`PERSONA_FK`) REFERENCES `PERSONAS`(`id`);
ALTER TABLE `ESTUDIANTE` ADD CONSTRAINT `ESTUDIANTE_fk1` FOREIGN KEY (`PERSONA_FK`) REFERENCES `PERSONAS`(`id`);
ALTER TABLE `DECANO` ADD CONSTRAINT `DECANO_fk1` FOREIGN KEY (`EMPLEADO_FK`) REFERENCES `EMPLEADO`(`id`);
ALTER TABLE `DOCENTE` ADD CONSTRAINT `DOCENTE_fk1` FOREIGN KEY (`EMPLEADO_FK`) REFERENCES `EMPLEADO`(`id`);
ALTER TABLE `MAESTRANZA` ADD CONSTRAINT `MAESTRANZA_fk1` FOREIGN KEY (`EMPLEADO_ID`) REFERENCES `EMPLEADO`(`id`);
ALTER TABLE `CURSO` ADD CONSTRAINT `CURSO_fk2` FOREIGN KEY (`DOCENTE_FK`) REFERENCES `DOCENTE`(`id`);
ALTER TABLE `CURSO` ADD CONSTRAINT `CURSO_fk3` FOREIGN KEY (`MATERIA_FK`) REFERENCES `MATERIA`(`id`);
ALTER TABLE `CURSO` ADD CONSTRAINT `CURSO_fk4` FOREIGN KEY (`ESTUDIANTE_FK`) REFERENCES `ESTUDIANTE`(`id`);
ALTER TABLE `CURSO` ADD CONSTRAINT `CURSO_fk5` FOREIGN KEY (`CARRERA_FK`) REFERENCES `CARRERA`(`id`);
ALTER TABLE `CURSO` ADD CONSTRAINT `CURSO_fk6` FOREIGN KEY (`AULA_FK`) REFERENCES `AULA`(`id`);
ALTER TABLE `CARRERA` ADD CONSTRAINT `CARRERA_fk7` FOREIGN KEY (`FACULTAD_FK`) REFERENCES `FACULTAD`(`id`);

ALTER TABLE PERSONAS MODIFY COLUMN APELLIDO VARCHAR(50);