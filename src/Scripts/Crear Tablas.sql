use [API]
go

begin tran

CREATE TABLE Usuarios (
	dni INT NOT NULL,
	nombre VARCHAR(60) NOT NULL,
	apellido VARCHAR(60) NOT NULL,
	fechaNacimiento DATE NOT NULL,
	mail VARCHAR(60) NOT NULL,
	pass  VARCHAR(15) NOT NULL,
	estado BIT NOT NULL, 
		CONSTRAINT Usr_PK PRIMARY KEY(dni)
)

CREATE TABLE Pagos (
	idPago INT NOT NULL,
	fechaPago DATE NOT NULL,
	monto float NOT NULL,
		CONSTRAINT Pago_PK PRIMARY KEY(idPago)
)


CREATE TABLE Agasajados (
	idAgasagado INT NOT NULL,
	nombreAgasajado VARCHAR(60) NOT NULL,
	fechaAgasajo DATE NOT NULL,
	email VARCHAR(60) NOT NULL,
	monto float NOT NULL,
		CONSTRAINT Agasajado_PK PRIMARY KEY(idAgasagado)
)

CREATE TABLE Listas (
	codLista INT NOT NULL,
	nombreLista VARCHAR(60) NOT NULL,
	dniAdmin INT NOT NULL,
	fechaInicio DATE NOT NULL,
	fechaFin DATE NOT NULL,
	idAgasajado INT NOT NULL,
	montoARecaudar float NOT NULL,
	estado BIT NOT NULL,
		CONSTRAINT Lista_PK PRIMARY KEY(codLista),
		CONSTRAINT ListaUsr_FK FOREIGN KEY(dniAdmin) REFERENCES Usuarios (dni),
		CONSTRAINT ListaAga_FK FOREIGN KEY(idAgasajado) REFERENCES Agasajados (idAgasagado)
)

CREATE TABLE ItemsLista (
	codItem INT NOT NULL,
	codLista INT NOT NULL,
	dniParticipante INT NOT NULL,
	idPago INT NOT NULL,
		CONSTRAINT Item_PK PRIMARY KEY(codLista, codItem ),
		CONSTRAINT ItemList_FK FOREIGN KEY(codLista) REFERENCES Listas (codLista),
		CONSTRAINT ItemUsr_FK FOREIGN KEY(dniParticipante) REFERENCES Usuarios (dni),
		CONSTRAINT ItemPago_FK FOREIGN KEY(idPago) REFERENCES Pagos (idPago),
)

GO