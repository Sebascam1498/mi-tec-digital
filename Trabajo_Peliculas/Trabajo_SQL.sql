
DROP SCHEMA IF EXISTS Movies;

CREATE DATABASE Movies;

USE Movies;

DROP TABLE IF EXISTS Movie;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Rating;
DROP TABLE IF EXISTS Users;


CREATE TABLE Category(
Id INT PRIMARY KEY AUTO_INCREMENT,
Name_Category VARCHAR(100)
);

CREATE TABLE Movie(
Id INT PRIMARY KEY AUTO_iNCREMENT,
Title VARCHAR(200),
ReleaseDate DATETIME,
Category_Id INT,
 CONSTRAINT Category_Fk FOREIGN KEY (Category_Id) REFERENCES Category(Id)
);


CREATE TABLE Users(
Id INT PRIMARY KEY AUTO_iNCREMENT,
User_Name VARCHAR(50),
First_Name VARCHAR(50),
Last_Name VARCHAR(50)
);

CREATE TABLE Rating(
Movie_Id INT,
Score INT check (Score >0 AND Score < 6),
Review VARCHAR(255),
User_Id INT,
CONSTRAINT Movie_Id_Fk FOREIGN KEY (Movie_Id) REFERENCES Movie(Id),
CONSTRAINT User_Id_Fk FOREIGN KEY (User_Id) REFERENCES Users(Id)
);

INSERT INTO Category(Name_Category) VALUES ("DRAMA");
INSERT INTO Category(Name_Category) VALUES ("ACCION");
INSERT INTO Category(Name_Category) VALUES ("SCI-FY");
INSERT INTO Category(Name_Category) VALUES ("TERROR");
INSERT INTO Category(Name_Category) VALUES ("HORROR");

INSERT INTO Movie(Title,ReleaseDate,Category_Id) VALUES ("Jurrasic Park","1998-04-01",1);
INSERT INTO Movie(Title,ReleaseDate,Category_Id) VALUES ("Avatar","2000-07-2",2);
INSERT INTO Movie(Title,ReleaseDate,Category_Id) VALUES ("In Time","2010-08-21",3);
INSERT INTO Movie(Title,ReleaseDate,Category_Id) VALUES ("El Titanic","1978-01-4",4);
INSERT INTO Movie(Title,ReleaseDate,Category_Id) VALUES ("Tarzan","2002-10-14",5);

INSERT INTO Users(User_Name,First_Name,Last_Name) VALUES ("LiteCore","Manuel","Calderon");
INSERT INTO Users(User_Name,First_Name,Last_Name) VALUES ("HighCore","Paula","Zamora");
INSERT INTO Users(User_Name,First_Name,Last_Name) VALUES ("HardCore","Sofia","Castro");
INSERT INTO Users(User_Name,First_Name,Last_Name) VALUES ("Sebas1409","Sebastian","Campos");
INSERT INTO Users(User_Name,First_Name,Last_Name) VALUES ("JP","Jorge","Perez");

INSERT INTO Rating(Movie_Id,Score,Review,User_Id) VALUES (1,4,"Buena",5);
INSERT INTO Rating(Movie_Id,Score,Review,User_Id) VALUES (2,2,"Mala",4);
INSERT INTO Rating(Movie_Id,Score,Review,User_Id) VALUES (3,1,"Muy MAla",3);
INSERT INTO Rating(Movie_Id,Score,Review,User_Id) VALUES (4,1,"Horrorossa",2);
INSERT INTO Rating(Movie_Id,Score,Review,User_Id) VALUES (5,5,"Increible",1);

