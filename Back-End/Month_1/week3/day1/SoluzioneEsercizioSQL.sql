DROP DATABASE esercizio1;
CREATE DATABASE esercizio1;

DROP TABLE Fatture;
DROP TABLE Clienti;
DROP TABLE Fornitori;
DROP TABLE Prodotti;

-- Clienti (NumeroCliente, Nome, Cognome, DataNascita, RegioneResidenza);
CREATE TABLE IF NOT EXISTS Clienti (
	NumeroCliente SERIAL PRIMARY KEY,
	Nome VARCHAR NOT NULL,
	Cognome VARCHAR NOT NULL,
	DataNascita Date NOT NULL,
	RegioneResidenza VARCHAR NOT NULL
);
-- Fornitori (NumeroFornitore, Denominazione, RegioneResidenza);
CREATE TABLE IF NOT EXISTS Fornitori (
	NumeroFornitore SERIAL PRIMARY KEY,
	Denominazione VARCHAR NOT NULL,
	RegioneResidenza VARCHAR NOT NULL
);
-- Fatture (NumeroFattura, Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore);
CREATE TABLE IF NOT EXISTS Fatture (
	NumeroFattura SERIAL PRIMARY KEY,
	Tipologia VARCHAR NOT NULL,
	Importo DECIMAL NOT NULL,
	Iva VARCHAR NOT NULL DEFAULT '20%',
	IdCliente INT8 NOT NULL,
	DataFattura Date NOT NULL,
	NumeroFornitore INT8 NOT NULL,
	CONSTRAINT Cliente_FK FOREIGN KEY (IdCliente) REFERENCES Clienti(NumeroCliente),
	CONSTRAINT Fornitore_FK FOREIGN KEY (NumeroFornitore) REFERENCES Fornitori(NumeroFornitore)
);
-- Prodotti (IdProdotto, Descrizione, InProduzione, InCommercio,  DataAttivazione, DataDisattivazione);
CREATE TABLE IF NOT EXISTS Prodotti (
	IdProdotto SERIAL PRIMARY KEY,
	Descrizione VARCHAR NOT NULL,
	InProduzione BOOLEAN NOT NULL DEFAULT 'false',
	InCommercio BOOLEAN NOT NULL DEFAULT 'false',
	DataAttivazione Date NOT NULL,
	DataDisattivazione Date NOT NULL
);

INSERT INTO Clienti(Nome, Cognome, DataNascita, RegioneResidenza ) 
		VALUES 	('Mario', 'Rossi', '1/8/1999', 'Lazio'),
				('Giuseppe', 'Verdi', '15/10/2000', 'Lombardia'),
				('Francesca', 'Neri', '24/4/2003', 'Campania'),
				('Antonio', 'Gialli', '29/5/1999', 'Sicilia');
				
				
INSERT INTO Fornitori(Denominazione, RegioneResidenza ) 
		VALUES 	('Epicode SRL', 'Lazio'),
				('JavaSchool SPA', 'Piemonte')
				
INSERT INTO Fatture(Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore) 
		VALUES 	('A', '145.12', '10%', 2, '2/2/2022', 1),
				('B', '533.99', '20%', 1, '29/4/2022', 2),
				('A', '145.12', '20%', 3, '12/1/2023', 1),
				('A', '188.00', '15%', 2, '2/2/2023', 1);

INSERT INTO Prodotti (Descrizione, InProduzione, InCommercio,  DataAttivazione, DataDisattivazione)
		VALUES 	('Prodotto x', true, false, '29/4/2017', '29/4/2023'),
				('Prodotto z', true, true, '15/9/2016', '15/9/2024'),
				('Prodotto q', false, false, '12/12/2017', '12/9/2022');
				
--  Estrarre il nome e il cognome dei clienti nati nel 1999
SELECT Nome, Cognome FROM Clienti WHERE DATE_PART('YEAR', DataNascita) = 1999;
-- Estrarre il numero delle fatture con iva al 20%
SELECT COUNT(*) AS ConteggioFatture FROM Fatture WHERE Iva = '20%';
-- Riportare il numero di fatture e la somma dei relativi importi divisi per anno di fatturazione
SELECT 
	DATE_PART('YEAR', DataFattura) AS Anno,
	COUNT(*) AS NumFatture,
	SUM(Importo) AS TotaleImporto
	FROM Fatture
	GROUP BY DATE_PART('YEAR', DataFattura);
-- Estrarre i prodotti attivati nel 2017 e che sono in produzione oppure in commercio
SELECT * 
	FROM Prodotti
	WHERE DATE_PART('YEAR', DataAttivazione) = 2017
			AND (InProduzione = true  OR  InCommercio = true);
-- Considerando soltanto le fatture con iva al 20 per cento, estrarre il numero di fatture per ogni anno
SELECT   
   DATE_PART('YEAR', DataFattura) AS Anno,
   COUNT(*) AS NumeroFatture
	FROM     Fatture
	WHERE    Iva='20%'
	GROUP BY DATE_PART('YEAR', DataFattura);
-- Estrarre gli anni in cui sono state registrate più di 2 fatture con tipologia ‘A’
SELECT  
   DATE_PART('YEAR', DataFattura) AS Anno,
   COUNT(*) AS NumeroFatture
	FROM     Fatture
	WHERE    Tipologia= 'A'
	GROUP BY DATE_PART('YEAR', DataFattura)
	HAVING   COUNT(*) > 1;
-- Riportare l’elenco delle fatture (numero, importo, iva e data) con in aggiunta il nome del fornitore
SELECT Fa.NumeroFattura, Fa.Importo, Fa.iva, Fa.DataFattura, Fo.Denominazione AS DenominazioneFornitori
	FROM Fatture as Fa LEFT JOIN Fornitori as Fo
 	ON Fa.NumeroFornitore = Fo.NumeroFornitore;
-- Estrarre il totale degli importi delle fatture divisi per residenza dei clienti
SELECT cl.RegioneResidenza, SUM(f.Importo) AS TotaleImporto
	FROM Fatture AS f INNER JOIN Clienti AS cl
  	ON f.IdCliente = cl.NumeroCliente
	GROUP BY cl.RegioneResidenza;
-- Estrarre il numero dei clienti nati nel 1980 che hanno almeno una fattura superiore a 50 euro
SELECT COUNT(DISTINCT C.NumeroCliente) AS NumeroClienti
	FROM  Clienti AS C INNER JOIN Fatture AS F
  	ON C.NumeroCliente = F.IdCliente
	WHERE DATE_PART('YEAR', DataNascita) = 1999
  	AND F.Importo > 50;
-- Estrarre una colonna di nome “Denominazione” contenente il nome, seguito da un carattere “-“,
-- seguito dal cognome, per i soli clienti residenti nella regione Lombardia
SELECT CONCAT(Nome, ' - ', Cognome) AS Denominazione
	FROM Clienti
	WHERE  RegioneResidenza = 'Lombardia';  


