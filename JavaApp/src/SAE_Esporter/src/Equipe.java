package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private int idEquipe;

    public int getIdEquipe() {
        return this.idEquipe;
    }

    public Equipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom_Equipe from Equipe where id_equipe = "+ this.getIdEquipe());
        	connex.close();
        	return rs.getString(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

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
    
    @Override
    public String toString() {
    	return "[ "+this.getNomEquipe() + " ]";
    }

}
