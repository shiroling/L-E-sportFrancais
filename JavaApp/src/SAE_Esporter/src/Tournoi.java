package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("06c0c323-453b-42a1-891b-30b23e1c142e")
public class Tournoi {
    @objid ("6000d04f-12f1-4c6d-a6e3-80f320240f18")
    private int idTournoi;

    @objid ("8cb74a55-fb51-4109-9aa4-d8d9e9482c60")
    public int getIdTournoi() {
        return this.idTournoi;
    }

    @objid ("c6f95866-06bd-49b3-a61a-c0ab774dc0ae")
    public Tournoi(int idTournoi) {
        this.idTournoi = idTournoi;
    }

    @objid ("f061a690-30f5-46ef-98f3-c62c823fab15")
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

    @objid ("dfcb7550-2bfe-4669-894e-0bdcc5e6501f")
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
