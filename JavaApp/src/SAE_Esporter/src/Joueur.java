package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3e879b81-1bda-4b1c-961e-8c745b74e436")
public class Joueur {
    @objid ("9f6ef509-d099-4b6a-8f6a-27a220348d79")
    private int idJoueur;

    @objid ("eeb5438f-827d-4f01-a288-f905dbe76884")
    public int getIdJoueur() {
        return this.idJoueur;
    }

    @objid ("b99d6e0f-e171-4d3b-a537-38be9dbc08b7")
    public Joueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    @objid ("f084088c-c59c-4eab-add3-9d3b0ccc86b1")
    public String getNom() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom from Joueur where id_joueur = "+ this.getIdJoueur());
        	rs.next();
        	String result = rs.getString(1);
        	connex.close();
        	return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    @objid ("b8a9de1f-f7ff-4a7d-a9a8-c77461ceea22")
    public String getPrenom() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Prenom from Joueur where id_joueur = "+ this.getIdJoueur());
        	rs.next();
        	String result = rs.getString(1);
        	connex.close();
        	return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    @objid ("0e1058ee-d6f8-4108-94ab-331c9177b180")
    public Date getDateNaissance() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Date_de_naissance from Joueur where id_joueur = "+ this.getIdJoueur());
        	rs.next();
        	Date result = rs.getDate(1);
        	connex.close();
        	return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    @objid ("6607ff67-ea71-46b6-92f9-f98d5b960622")
    public String getPseudo() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Pseudo from Joueur where id_Joueur = "+ this.getIdJoueur());
        	rs.next();
        	String result = rs.getString(1);
        	connex.close();
        	return result;
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
