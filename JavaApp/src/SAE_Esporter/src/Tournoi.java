package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Tournoi {
    private int idTournoi;

    public int getIdTournoi() {
        return this.idTournoi;
    }

    public Tournoi(int idTournoi) {
        this.idTournoi = idTournoi;
    }

    public String getNomTournoi() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom from Tournoi where id_tournoi = "+ this.getIdTournoi());
        	connex.close();
        	return rs.getString(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    public List<Equipe> getListEquipesParticipantes() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select id_equipe from incrit where id_Tournoi = "+ this.getIdTournoi());
        	
        	List<Equipe> equipes = new ArrayList<>();
        	while(rs.next()) {
        		equipes.add(new Equipe(rs.getInt(1)));
        	}
        	connex.close();
        	return equipes;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    public static void creerTournoi(String nom, Portee p, Date dateDebut, Date dateFin) { 
    }
    
    public Date getDateInscriptionEquipe(Equipe equipe) {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select dateInscription from inscrit where id_tournoi = "+ this.getIdTournoi() + " and id_equipe = " + equipe.getIdEquipe());
        	connex.close();
        	return rs.getDate(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    @Override
    public String toString() {
    	return this.getNomTournoi();
    }

}
