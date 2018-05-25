use [API]
go

begin tran

CREATE TABLE Usuarios (
	dni INT NOT NULL,
	nombre VARCHAR(60) NOT NULL,
	apellido VARCHAR(60) NOT NULL,
	fechaNacimiento DATE NOT NULL,
	mail VARCHAR(40) NOT NULL,
	pass  VARCHAR(15) NOT NULL,
	estado BIT NOT NULL, 
		CONSTRAINT Vend_PK PRIMARY KEY(dni),
)
GO