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