package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f38b193e-acac-4040-9dc4-7b7dda061120")
public class Equipe {
    @objid ("29e90e63-efed-4d75-aba9-954617c74718")
    private int idEquipe;

    @objid ("a3a2e72d-bb4c-4e92-a98b-a3f7b12f5ca2")
    public int getIdEquipe() {
        return this.idEquipe;
    }

    @objid ("e6f3a80e-b468-41f7-a247-0c3006f812b3")
    public Equipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    @objid ("422359c7-b11d-4995-8de0-1f080021b906")
    public String getNomEquipe() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom_Equipe from Equipe where id_equipe = "+ this.getIdEquipe());
        	rs.next();
        	String result = rs.getString(1);
        	connex.close();
        	return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    @objid ("e9738db4-546d-4407-bf14-2d96a117e6e3")
    public List<Joueur> getListJoueur() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select id_Joueur from Joueur where id_Equipe = "+ this.getIdEquipe());
        	
        	List<Joueur> joueurs = new ArrayList<>();
        	while(rs.next()) {
        		joueurs.add(new Joueur(rs.getInt(1)));
        	}
        	connex.close();
        	return joueurs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    public static String[] getToutesLesEquipes() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("SELECT id_Equipe from Equipe");
        	List<Equipe> equipes = new ArrayList<>();
        	while(rs.next()) {
        		equipes.add(new Equipe(rs.getInt(1)));
        	}
        	connex.close();
        	
        	String[] nomEquipes = new String[equipes.size()];
        	for(int i = 0; i < equipes.size() ; i++) {
        		nomEquipes[i] = equipes.get(i).toString();
        	}
        	return nomEquipes;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    @Override
    public String toString() {
    	return this.getNomEquipe();
    }

}
