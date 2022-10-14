package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Rencontre {
    private int idRencontre;

    public int getIdRencontre() {
        return this.idRencontre;
    }

    public Rencontre(int idRencontre) {
        this.idRencontre = idRencontre;
    }

    public List<Equipe> getEquipes() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = "+ this.getIdRencontre());
        	
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

    public Equipe getVainqueur() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = "+ this.getIdRencontre() + " and a_gagne = 1");
        	return new Equipe(rs.getInt(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    public Equipe getPerdant() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = "+ this.getIdRencontre() + " and a_gagne = 0");
        	return new Equipe(rs.getInt(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    public Date getDateRencontre() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Date_rencontre from Rencontre where id_Rencontre = "+ this.getIdRencontre());
        	return rs.getDate(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    @Override
    public String toString() {
    	return " [ " + this.getEquipes().get(0).toString() + " / " + this.getEquipes().get(1).toString() + " ] ";
    }

}
