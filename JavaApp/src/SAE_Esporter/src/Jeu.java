package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("394ce37b-241f-4c3a-9a52-aef30578eb8f")
public class Jeu {
    @objid ("b7f84329-b94b-4b6a-80f3-37981a35e0ad")
    private int idJeu;

    @objid ("0d99f13e-60b1-49d5-ad05-1e5e8d5a6321")
    public int getIdJeu() {
        return this.idJeu;
    }

    @objid ("a416c6e5-54f2-442c-9333-bc3a83831efa")
    public Jeu(int idJeu) {
        this.idJeu = idJeu;
    }

    @objid ("b6ccf15a-820e-4585-89b0-e046a16908ea")
    public String getNomJeu() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom_jeu from Jeu where id_Jeu = "+ this.getIdJeu());
        	rs.next();
        	String result = rs.getString(1);
        	connex.close();
        	return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    public static String[] getTousLesJeux() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("SELECT id_Jeu from Jeu");
        	List<Jeu> jeux = new ArrayList<>();
        	while(rs.next()) {
        		jeux.add(new Jeu(rs.getInt(1)));
        	}
        	connex.close();
        	
        	String[] nomJeux = new String[jeux.size()];
        	for(int i = 0; i < jeux.size() ; i++) {
        		nomJeux[i] = jeux.get(i).toString();
        	}
        	return nomJeux;
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
