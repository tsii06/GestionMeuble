CREATE DATABASE Meuble;

\c meuble;

CREATE TABLE Matiere(
	idMatiere SERIAL PRIMARY KEY,
	nom VARCHAR(50),
	prixunitaire DECIMAL(12,2)
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

CREATE TABLE Metier(
	idMetier SERIAL PRIMARY KEY,
	nom VARCHAR(20),
	salaire DECIMAL(12,2)
);

CREATE table stock(
	idStock SERIAL PRIMARY KEY,
	idMatiere int,
	quantite int,
	dateMouvement date,
	type int,
	FOREIGN KEY (idMatiere) REFERENCES Matiere(idMatiere)
);


CREATE table mouvement(
	idStock SERIAL PRIMARY KEY,
	idMatiere int,
	prixunitaire DECIMAL(12,2),
	quantite int,
	dateMouvement date,
	type int,
	FOREIGN KEY (idMatiere) REFERENCES Matiere(idMatiere)
);

CREATE table stockmeuble(
	idStock SERIAL PRIMARY KEY,
	idMeuble int,
	quantite int,
	dateMouvement date,
	type int,
	FOREIGN KEY (idMeuble) REFERENCES Meuble(idMeuble)
);


CREATE table mouvementmeuble(
	idStock SERIAL PRIMARY KEY,
	idMeuble int,
	prixunitaire DECIMAL(12,2),
	quantite int,
	dateMouvement date,
	type int,
	FOREIGN KEY (idMeuble) REFERENCES Meuble(idMeuble)
);



CREATE TABLE Fabrication(
	idFabrication SERIAL PRIMARY KEY,
	idMeuble INT,
	prixVente DECIMAL(12,2),
	FOREIGN KEY (idMeuble) REFERENCES Meuble(idMeuble)
);

CREATE TABLE MetierFabrication(
	idFabrication INT,
	idMetier INT,
	heure INT,
	nombre INT,
	FOREIGN KEY (idFabrication) REFERENCES Fabrication(idFabrication),
	FOREIGN KEY (idMetier) REFERENCES Metier(idMetier)
);

CREATE TABLE Employer(
	idEmployer SERIAL PRIMARY KEY,
	idMetier INT,
	nom VARCHAR(40),
	dateEmbauche DATE,
	FOREIGN KEY (idMetier) REFERENCES Metier(idMetier)
);

CREATE TABLE Client(
	idClient SERIAL PRIMARY KEY,
	nom VARCHAR(40),
	dateNaissance DATE,
	genre int
);

CREATE TABLE Vente(
	idVente SERIAL PRIMARY KEY,
	idClient int,
	idMeuble int,
	dateVente DATE,
	quantite int,
	FOREIGN KEY (idClient) REFERENCES Client(idClient),
	FOREIGN KEY (idMeuble) REFERENCES Meuble(idMeuble)
);



CREATE view vmatiere as 
SELECT mm.idMeuble,mm.quantite*m.prixunitaire as prix from MeubleMatiere mm 
join Matiere m on m.idMatiere=mm.idMatiere;

CREATE VIEW VStyle AS 
SELECT M.idMatiere , M.nom AS nomMatiere, S.idStyle , S.nom AS nomStyle FROM StyleMatiere SM
JOIN Matiere M ON SM.idMatiere=M.idMatiere
JOIN Style S ON SM.idStyle=S.idStyle;

CREATE VIEW VMeuble AS 
SELECT MM.* , M.nom , M.type FROM MeubleMatiere MM
JOIN Meuble M ON MM.idMeuble=M.idMeuble;

CREATE VIEW VFabrication AS 
SELECT F.idMeuble , M.salaire*MF.heure*MF.nombre AS prixRevient , F.prixVente FROM Metier M
JOIN MetierFabrication MF ON MF.idMetier=M.idMetier
JOIN Fabrication F ON MF.idFabrication=F.idFabrication;

CREATE VIEW VSomme AS 
SELECT M.* , sum(prix) AS prix FROM vmatiere VM
JOIN Meuble M ON M.idMeuble=VM.idMeuble
GROUP BY M.idMeuble
ORDER BY M.idMeuble;

CREATE VIEW vprixrevient AS
SELECT VF.idMeuble , VF.prixrevient+VS.prix AS prixRevient FROM VFabrication VF
JOIN VSomme VS ON VS.idMeuble=VF.idMeuble;



CREATE VIEW VBenefice AS
SELECT VS.idMeuble , VS.nom , VS.type , VF.prixVente-VPR.prixrevient AS benefice , VPR.prixrevient , VF.prixVente AS prixVente FROM VSomme VS
JOIN vprixrevient VPR ON VPR.idMeuble=VS.idMeuble
JOIN VFabrication VF ON VF.idMeuble=VS.idMeuble;

CREATE VIEW VEmployer AS
SELECT E.idEmployer , E.nom AS nomEmployer , E.dateEmbauche , M.idMetier , M.nom AS nomMetier , M.salaire FROM Employer E
JOIN Metier M ON M.idMetier=E.idMetier;

CREATE VIEW Vvente AS
SELECT V.quantite,Cl.genre,M.idMeuble FROM vente V
JOIN Client Cl ON V.idClient=Cl.idClient
JOIN Meuble M ON M.idMeuble=V.idMeuble;


	INSERT INTO Matiere (nom,prixunitaire) VALUES ('Bois',2000);
	INSERT INTO Matiere (nom,prixunitaire) VALUES ('Fer',6000);
	INSERT INTO Matiere (nom,prixunitaire) VALUES ('fil',2000);

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

	INSERT INTO Metier (nom,salaire) VALUES ('metier1',2000);
	INSERT INTO Metier (nom,salaire) VALUES ('metier2',3500);	

	INSERT INTO Fabrication (idMeuble,prixVente) VALUES (1,150000);
	INSERT INTO Fabrication (idMeuble,prixVente) VALUES (2,200000);

	INSERT INTO MetierFabrication VALUES (1,3,6,5);
	INSERT INTO MetierFabrication VALUES (2,2,2,9);

	INSERT INTO Employer (idMetier,nom,dateEmbauche) VALUES (1,'employer1','01-01-2021');
--==================
	INSERT INTO Client (nom,dateNaissance,genre) VALUES ('Ngia Ndriana','01-01-2004',0);
	INSERT INTO Client (nom,dateNaissance,genre) VALUES ('Mary','01-01-1999',1);

	INSERT INTO Vente (idClient,idMeuble,dateVente,quantite) VALUES (1,2,'01-02-2024',3);