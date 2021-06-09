DROP DATABASE IF EXISTS ecommerce;
CREATE DATABASE ecommerce; 
USE ecommerce;
CREATE TABLE Cliente(
	email CHAR(100) NOT NULL,
    psw CHAR(64),
    nome CHAR(50) NOT NULL,
    cognome CHAR(50) NOT NULL,
    città CHAR(50) NOT NULL,
    provincia CHAR(5) NOT NULL,
    via CHAR(150) NOT NULL,
	numeroCivico INT,
    cap INT,
    PRIMARY KEY(email)
);
 CREATE TABLE StatoDiElaborazione(
stato CHAR(60),
UNIQUE(stato)
);
CREATE TABLE Ordine(
numeroOrdine CHAR(10) NOT NULL,
dataOrdine TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
importoOrdine FLOAT(10),
email CHAR(100) ,
stato CHAR(20),
FOREIGN KEY(email) REFERENCES Cliente(email),
FOREIGN KEY(stato) REFERENCES StatoDiElaborazione(stato) ,
PRIMARY KEY(numeroOrdine)
);
 CREATE TABLE Pagamento(
	IDpagamento INT AUTO_INCREMENT NOT NULL,
    valuta CHAR(1),
    importo FLOAT(10),
    dataPagamento TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    email CHAR(100),
    numeroOrdine CHAR(10),
    FOREIGN KEY (numeroOrdine) REFERENCES Ordine(numeroOrdine) ,
    FOREIGN KEY (email) REFERENCES Cliente (email),
    PRIMARY KEY(IDpagamento)
    );
CREATE TABLE Contrassegno(
	città CHAR(100) NOT NULL,
    provincia CHAR(5) NOT NULL,
    CAP INT NOT NULL,
    via CHAR(150) NOT NULL,
    numeroCivico INT,
    IDpagamento INT,
    FOREIGN KEY(IDpagamento) REFERENCES Pagamento(IDpagamento)
    );

CREATE TABLE CartaDiCredito(
	numeroCarta CHAR(16) NOT NULL,
    intestatarioCarta CHAR(100) NOT NULL,
    dataScadenza CHAR(5) NOT NULL,
    IDpagamento INT,
    FOREIGN KEY(IDpagamento) REFERENCES Pagamento(IDpagamento)
    );
CREATE TABLE PayPal(
	email CHAR(150),
    psw CHAR(150),
	IDpagamento INT,
	FOREIGN KEY(IDpagamento) REFERENCES Pagamento(IDpagamento)
);
CREATE TABLE Carrello(
	numero INT AUTO_INCREMENT NOT NULL,
	capienza INT,
	email CHAR(100),
	FOREIGN KEY(email) REFERENCES Cliente(email),
	PRIMARY KEY(numero)
);
CREATE TABLE AziendaCostruttrice(
IDazienda CHAR(5),
PRIMARY KEY(IDazienda)
);
CREATE TABLE Prodotto(
	codice CHAR(20) NOT NULL,
	nome TEXT(500) NOT NULL,
	genere CHAR(20),
	prezzo  FLOAT(10),
    PRIMARY KEY(codice)
);
CREATE TABLE Gestore(
IDgestore INT AUTO_INCREMENT NOT NULL,
codiceFiscale CHAR(16),
ragioneSociale CHAR(50),
IDazienda CHAR(5),
FOREIGN KEY(IDazienda) REFERENCES AziendaCostruttrice(IDazienda),
PRIMARY KEY(IDgestore)
);
CREATE TABLE Magazzino(
IDmagazzino INT,
PRIMARY KEY(IDmagazzino)
);
CREATE TABLE inserito(
email CHAR(100),
codice CHAR(20),
FOREIGN KEY(email) REFERENCES Cliente(email),
FOREIGN KEY(codice) REFERENCES Prodotto(codice) 
);
CREATE TABLE risiede(
disponibilità INT,
codice CHAR(20),
IDmagazzino INT,
FOREIGN KEY(codice) REFERENCES Prodotto(codice) ,
FOREIGN KEY(IDmagazzino) REFERENCES Magazzino(IDmagazzino)
);
CREATE TABLE composto(
quantità INT,
codice CHAR(20),
numeroOrdine CHAR(10),
FOREIGN KEY(numeroOrdine) REFERENCES Ordine(numeroOrdine),
FOREIGN KEY(codice) REFERENCES Prodotto(codice)
);
CREATE TABLE costruito(
codice CHAR(20),
IDazienda CHAR(5),
FOREIGN KEY(codice) REFERENCES Prodotto(codice),
FOREIGN KEY(IDazienda) REFERENCES aziendaCostruttrice(IDazienda)
);






