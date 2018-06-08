use [API]
go

CREATE TABLE Usuarios (
	dni INT NOT NULL,
	nombre VARCHAR(60) NOT NULL,
	apellido VARCHAR(60) NOT NULL,
	fechaNacimiento DATE NOT NULL,
	mail VARCHAR(60) NOT NULL,
	pass  VARCHAR(15) NOT NULL,
	estado BIT NOT NULL, 
		CONSTRAINT Usr_PK PRIMARY KEY(dni),
		
)
CREATE NONCLUSTERED INDEX IX_Usr_Email ON Usuarios (mail); 

CREATE TABLE Pagos (
	idPago INT NOT NULL,
	fechaPago DATE NOT NULL,
	monto float NOT NULL,
		CONSTRAINT Pago_PK PRIMARY KEY(idPago)
)

CREATE TABLE Listas (
	codLista INT IDENTITY NOT NULL,
	nombreLista VARCHAR(60) NOT NULL,
	dniAdmin INT NOT NULL,
	fechaInicio DATE NOT NULL,
	fechaFin DATE NOT NULL,
	nombreAgasajado VARCHAR(60) NOT NULL,
	fechaAgasajo DATE NOT NULL,
	emailAgasajado VARCHAR(60) NOT NULL,
	montoARecaudar float NOT NULL,
	estado char NOT NULL,
		CONSTRAINT Lista_PK PRIMARY KEY(codLista),
		CONSTRAINT ListaUsr_FK FOREIGN KEY(dniAdmin) REFERENCES Usuarios (dni)
)

CREATE TABLE ItemsLista (
	codLista INT NOT NULL,
	dniParticipante INT NOT NULL,
	idPago INT NULL,
		CONSTRAINT Item_PK PRIMARY KEY(codLista, dniParticipante ),
		CONSTRAINT ItemList_FK FOREIGN KEY(codLista) REFERENCES Listas (codLista),
		CONSTRAINT ItemUsr_FK FOREIGN KEY(dniParticipante) REFERENCES Usuarios (dni),
		CONSTRAINT ItemPago_FK FOREIGN KEY(idPago) REFERENCES Pagos (idPago),
)

GO