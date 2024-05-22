CREATE DATABASE Meuble;

\c meuble;

CREATE TABLE Matiere(
	idMatiere SERIAL PRIMARY KEY,
	nom VARCHAR(50)
);

CREATE TABLE Style(
	idStyle SERIAL PRIMARY KEY,
	nom VARCHAR(50)
);

CREATE TABLE Categorie(
	idCategorie SERIAL PRIMARY KEY,
	nom VARCHAR(50)
);

CREATE TABLE Meuble(
	idMeuble SERIAL PRIMARY KEY,
	nom VARCHAR(50),
	idStyle INT,
	idCategorie INT,
	type VARCHAR(50),
	FOREIGN KEY (idStyle) REFERENCES Style(idStyle),
	FOREIGN KEY (idCategorie) REFERENCES Categorie(idCategorie)
);

CREATE TABLE StyleMatiere(
	idStyle INT,
	idMatiere INT,
	FOREIGN KEY (idStyle) REFERENCES Style(idStyle),
	FOREIGN KEY (idMatiere) REFERENCES Matiere(idMatiere)
);

CREATE TABLE MeubleMatiere(
	idMeuble INT,
	idMatiere INT,
	quantite INT,
	FOREIGN KEY (idMeuble) REFERENCES Meuble(idMeuble),
	FOREIGN KEY (idMatiere) REFERENCES Matiere(idMatiere)
);

CREATE VIEW VStyle AS 
SELECT M.idMatiere , M.nom AS nomMatiere, S.idStyle , S.nom AS nomStyle FROM StyleMatiere SM
JOIN Matiere M ON SM.idMatiere=M.idMatiere
JOIN Style S ON SM.idStyle=S.idStyle;

CREATE VIEW VMeuble AS 
SELECT MM.* , M.nom , M.type FROM MeubleMatiere MM
JOIN Meuble M ON MM.idMeuble=M.idMeuble;


	INSERT INTO Matiere (nom) VALUES ('Bois');
	INSERT INTO Matiere (nom) VALUES ('Fer');

	INSERT INTO Style (nom) VALUES ('neutre');
	INSERT INTO Style (nom) VALUES ('rural');

	INSERT INTO Categorie (nom) VALUES ('Table');
	INSERT INTO Categorie (nom) VALUES ('Canape');
	INSERT INTO Categorie (nom) VALUES ('Chaise');

	INSERT INTO Meuble (idStyle,type,idCategorie,nom) VALUES (1,'PM',1,'meuble1');
	INSERT INTO Meuble (idStyle,type,idCategorie,nom) VALUES (2,'GM',3,'meuble2');

	INSERT INTO StyleMatiere VALUES (1,1);
	INSERT INTO StyleMatiere VALUES (1,2);
	INSERT INTO StyleMatiere VALUES (2,1);
	INSERT INTO StyleMatiere VALUES (2,2);

	INSERT INTO MeubleMatiere VALUES (1,1,10);
	INSERT INTO MeubleMatiere VALUES (1,2,4);
	INSERT INTO MeubleMatiere VALUES (2,1,20);

