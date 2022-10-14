package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Poule {
    private int idPoule;

    public int getIdPoule() {
        return this.idPoule;
    }

    public Poule(int idPoule) {
        this.idPoule = idPoule;
    }

    public boolean isPouleFinal() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Final from Poule where id_Poule = "+ this.getIdPoule());
        	connex.close();
        	return rs.getBoolean(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
    }

}
