package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Jeu {
    private int idJeu;

    public int getIdJeu() {
        return this.idJeu;
    }

    public Jeu(int idJeu) {
        this.idJeu = idJeu;
    }

    public String getNomJeu() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom_jeu from Jeu where id_Jeu = "+ this.getIdJeu());
        	connex.close();
        	return rs.getString(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    @Override
    public String toString() {
    	return this.getNomJeu();
    }

}
