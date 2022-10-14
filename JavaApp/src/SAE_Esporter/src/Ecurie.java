package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ecurie {
    private int idEcurie;

    public int getIdEcurie() {
        return this.idEcurie;
    }

    public Ecurie(int idEcurie) {
        this.idEcurie = idEcurie;
    }

    public List<Equipe> getListEquipe() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select id_equipe from Equipe where id_Ecurie = "+ this.getIdEcurie());
        	
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

public String getNomEcurie() {
    Connection connex = ConnexionBase.getConnection();
    try {
    	Statement st = connex.createStatement();
    	ResultSet rs = st.executeQuery("Select Nom_ecurie from Ecurie where id_Ecurie = "+ this.getIdEcurie());
        rs.next();
    	String temp = rs.getNString("Nom_ecurie");
    	connex.close();
    	return temp;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return null;
	}
}

    public String getNomManager() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom_manager from Ecurie where id_Ecurie = "+ this.getIdEcurie());
            rs.next();

        	String temp = rs.getNString("Nom_manager");
        	connex.close();
        	return temp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    @Override
    public String toString() {
    	return this.getNomEcurie() + " (" +this.getNomManager()+ ")";
    }
}
