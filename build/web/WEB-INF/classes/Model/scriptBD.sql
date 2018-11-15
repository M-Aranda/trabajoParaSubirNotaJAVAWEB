CREATE DATABASE ejercicioParaSubirNotaJavaWeb;

USE ejercicioParaSubirNotaJavaWeb;

CREATE TABLE rol(
id INT AUTO_INCREMENT,
tipo VARCHAR (30),
PRIMARY KEY(id)
);

CREATE TABLE usuarioNormal(
id INT AUTO_INCREMENT,
rut VARCHAR (40) UNIQUE,
nombre VARCHAR (40),
contrasenia VARCHAR (30),
fk_rol INT,
FOREIGN KEY(fk_rol) REFERENCES rol (id),
PRIMARY KEY(id)
);

CREATE TABLE administrador(
id INT AUTO_INCREMENT,
rut VARCHAR (40) UNIQUE,
nombre VARCHAR (40),
contrasenia VARCHAR (30),
fk_rol INT,
FOREIGN KEY(fk_rol) REFERENCES rol(id),
PRIMARY KEY(id)
);


CREATE TABLE casa(
id INT AUTO_INCREMENT, -- el id es el numero de rol
direccion VARCHAR (60),
metrosCuadrados INT,
rutProp VARCHAR (40),
nomPropietario VARCHAR (40),
avaluoFiscal INT,
PRIMARY KEY(id)
);

INSERT INTO rol VALUES(NULL, 'Usuario Normal');
INSERT INTO rol VALUES(NULL, 'Administrador');

INSERT INTO administrador VALUES (NULL, '11-1', 'Marcelo Aranda','admin',2);
INSERT INTO usuarioNormal VALUES (NULL, '22-2', 'Gonzalo','hola',1);
INSERT INTO usuarioNormal VALUES (NULL, '33-3', 'Lena Oxton','123',1);


INSERT INTO casa VALUES(NULL, 'El Roble 1980', 300, '20','Caty', 30000);
INSERT INTO casa VALUES(NULL, 'El Roble 2300', 300, '20','Caty', 30000);
INSERT INTO casa VALUES(NULL, 'El Roble 1990', 300, '20','Caty', 30000);
INSERT INTO casa VALUES(NULL, 'El Roble 101', 300, '30','Casandra', 30000);


-- SELECT * FROM usuarioNormal;
-- SELECT * FROM administrador;

-- DROP DATABASE ejercicioParaSubirNotaJavaWeb;