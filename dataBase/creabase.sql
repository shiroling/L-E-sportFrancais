CREATE TABLE Ecurie(
   Id_Ecurie INT,
   Nom_Ecurie VARCHAR(50) NOT NULL,
   Nom_Manager VARCHAR(50) NOT NULL,
   mdp_Manager VARCHAR(50) NOT NULL,
   PRIMARY KEY(Id_Ecurie),
   UNIQUE(Nom_Ecurie)
);
CREATE SEQUENCE Seq_Ecurie START WITH 1 INCREMENT BY 1;

CREATE TABLE Jeu(
   Id_Jeu INT,
   Nom_jeu VARCHAR(50) NOT NULL,
   PRIMARY KEY(Id_Jeu),
   UNIQUE(Nom_jeu)
);
CREATE SEQUENCE Seq_Jeu START WITH 1 INCREMENT BY 1;

CREATE TABLE Arbitre(
   Id_Arbitre INT,
   Nom VARCHAR(50),
   mdp VARCHAR(50),
   PRIMARY KEY(Id_Arbitre)
);
CREATE SEQUENCE Seq_Arbitre START WITH 1 INCREMENT BY 1;

CREATE TABLE Gerant(
   Id_Gerant INT,
   Nom VARCHAR(50) NOT NULL,
   mdp VARCHAR(50) NOT NULL,
   PRIMARY KEY(Id_Gerant)
);
CREATE SEQUENCE Seq_Gerant START WITH 1 INCREMENT BY 1;

CREATE TABLE Equipe(
   Id_Equipe INT,
   nom_Equipe VARCHAR(50) NOT NULL,
   Id_Jeu INT NOT NULL,
   Id_Ecurie INT NOT NULL,
   PRIMARY KEY(Id_Equipe),
   UNIQUE(nom_Equipe),
   FOREIGN KEY(Id_Jeu) REFERENCES Jeu(Id_Jeu),
   FOREIGN KEY(Id_Ecurie) REFERENCES Ecurie(Id_Ecurie)
);
CREATE SEQUENCE Seq_Equipe START WITH 1 INCREMENT BY 1;

CREATE TABLE Joueur(
   Id_Joueur INT,
   Nom VARCHAR(50) NOT NULL,
   Prenom VARCHAR(50) NOT NULL,
   Date_De_Naissance DATE NOT NULL,
   Pseudo VARCHAR(50) NOT NULL,
   Id_Equipe INT NOT NULL,
   PRIMARY KEY(Id_Joueur),
   FOREIGN KEY(Id_Equipe) REFERENCES Equipe(Id_Equipe)
);
CREATE SEQUENCE Seq_Joueur START WITH 1 INCREMENT BY 1;

CREATE TABLE Tournoi(
   Id_Tournoi INT,
   nom VARCHAR(50) NOT NULL,
   Portée VARCHAR(50) NOT NULL,
   dateFinInsriptions DATE NOT NULL,
   dateDebutTournoi DATE NOT NULL,
   dateFinTournoi DATE NOT NULL,
   Id_Jeu INT NOT NULL,
   Id_Gerant INT NOT NULL,
   PRIMARY KEY(Id_Tournoi),
   FOREIGN KEY(Id_Gerant) REFERENCES Gerant(Id_Gerant),
   FOREIGN KEY(Id_Jeu) REFERENCES Jeu(Id_Jeu),
   CONSTRAINT CK_Tournoi_Portée CHECK (Portée in ('Local','National','International')),
   UNIQUE(nom)

);
CREATE SEQUENCE Seq_Tournoi START WITH 1 INCREMENT BY 1;

CREATE TABLE Poule(
   Id_Poule INT,
   Finale INT,
   Id_Tournoi INT NOT NULL,
   PRIMARY KEY(Id_Poule),
   FOREIGN KEY(Id_Tournoi) REFERENCES Tournoi(Id_Tournoi),
   CONSTRAINT ck_finale_in CHECK (Finale in (0,1))
);
CREATE SEQUENCE Seq_Poule START WITH 1 INCREMENT BY 1;

CREATE TABLE Rencontre(
   Id_Rencontre INT,
   Id_Arbitre INT NOT NULL,
   Id_Poule INT NOT NULL,
   Date_Renconter DATE not null,
   PRIMARY KEY(Id_Rencontre),
   FOREIGN KEY(Id_Arbitre) REFERENCES Arbitre(Id_Arbitre),
   FOREIGN KEY(Id_Poule) REFERENCES Poule(Id_Poule)
);
CREATE SEQUENCE Seq_Rencontre START WITH 1 INCREMENT BY 1;

CREATE TABLE Inscrit(
   Id_Equipe INT NOT NULL,
   Id_Tournoi INT NOT NULL,
   dateInscription DATE NOT NULL,
   PRIMARY KEY(Id_Equipe, Id_Tournoi),
   FOREIGN KEY(Id_Equipe) REFERENCES Equipe(Id_Equipe),
   FOREIGN KEY(Id_Tournoi) REFERENCES Tournoi(Id_Tournoi)
);

CREATE TABLE Composer(
   Id_Equipe INT,
   Id_Poule INT,
   PRIMARY KEY(Id_Equipe, Id_Poule),
   FOREIGN KEY(Id_Equipe) REFERENCES Equipe(Id_Equipe),
   FOREIGN KEY(Id_Poule) REFERENCES Poule(Id_Poule)
);

CREATE TABLE Jouer(
   Id_Equipe INT NOT NULL,
   Id_Rencontre INT NOT NULL,
   a_gagne INT,
   PRIMARY KEY(Id_Equipe, Id_Rencontre),
   FOREIGN KEY(Id_Equipe) REFERENCES Equipe(Id_Equipe),
   FOREIGN KEY(Id_Rencontre) REFERENCES Rencontre(Id_Rencontre),
   CONSTRAINT ck_aGagne_in CHECK (a_gagne in (0,1))
);

ALTER TABLE  Joueur ADD CONSTRAINT ck_card_equipe CHECK ((select MAX(COUNT(Id_Equipe)) FROM Joueur GROUP BY Id_Equipe) < 5);