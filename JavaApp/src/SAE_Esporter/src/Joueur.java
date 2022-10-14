package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class Joueur {
    private int idJoueur;

    public int getIdJoueur() {
        return this.idJoueur;
    }

    public Joueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNom() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom from Joueur where id_joueur = "+ this.getIdJoueur());
        	connex.close();
        	return rs.getString(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    public String getPrenom() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Prenom from Joueur where id_joueur = "+ this.getIdJoueur());
        	connex.close();
        	return rs.getString(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    public Date getDateNaissance() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Date_de_naissance from Joueur where id_joueur = "+ this.getIdJoueur());
        	connex.close();
        	return rs.getDate(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    public String getPseudo() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Pseudo from Joueur where id_Joueur = "+ this.getIdJoueur());
        	connex.close();
        	return rs.getString(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    @Override 
    public String toString() {
    	return "[" + this.getPseudo() +"] " + this.getNom() + " " + this.getPrenom() + "  --- " + this.getDateNaissance().toString(); 
    }

}
