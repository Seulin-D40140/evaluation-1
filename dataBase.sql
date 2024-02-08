DROP DATABASE IF EXISTS Stage;
CREATE DATABASE Stage;
USE Stage;

-- construction de la table des articles en vente 

CREATE TABLE T_Stages 
(
	idStage			int(4)			PRIMARY KEY AUTO_INCREMENT,
	Name			varchar(30)		NOT NULL,
	Description		varchar(50)		NOT NULL,
	Duration		int(8)			NOT NULL,
	Type 			varchar(30)		NOT NULL,
	UnitaryPrice	float(8)		NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Stages ( Name , Description , Duration , Type , UnitaryPrice ) VALUES ( "Java" , "Java se8" , 20 , "presential" , 120 ),
																					( "Java avancer" , "exeption fichier.." , 20 , "presential" , 150 ),
																					( "Java" , "Java se11" , 20 , "remote" , 160 ),
																					( "Spring" , "Spring core/mvc" , 30 , "presential" , 200 ),
																					( "Php" , "symphony" , 15 , "remote" , 100 ),
																					( "C#" , "dotnet core" , 25 , "presential" , 180 ),
																					( "Javascript" , "js avancer" , 28 , "presential" , 230 ),
																					( "Html" , "html simple" , 9 , "remote" , 90 ),
																					( "Css" , "stylesheet" , 5 , "remote" , 50 );
																					
CREATE TABLE T_Users 
(
	idUser			int(4)			PRIMARY KEY AUTO_INCREMENT,
	Login			varchar(30)		NOT NULL,
	Password		varchar(50)		NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users ( Login , Password ) VALUES ( "toto40" , "taratoto40" );

CREATE TABLE T_Customers
(
	idCustomer			int(4)		PRIMARY KEY AUTO_INCREMENT,
	Name			varchar(20)		NOT NULL,
	FirstName		varchar(20)		NOT NULL,
	Email 			varchar(50)		NOT NULL,
	Phone			int(10)			NOT NULL,
	Adress			varchar(50)		NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Customers ( Name , FirstName , Email , Phone , Adress ) VALUES ( "toto" , "tara" , "TaraT@hotmail.fr" , 0568542582 , "12 rue des roses 40260 dax");

ALTER TABLE t_Users ADD COLUMN idPerson INT(4);
ALTER TABLE t_Users ADD FOREIGN KEY(idPerson) REFERENCES T_Customers(idCustomer);
update t_Users set idPerson=1 where idUser=1;

