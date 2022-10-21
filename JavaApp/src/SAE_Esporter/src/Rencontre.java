package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("01ec42e6-1340-4440-8beb-c29f380e426e")
public class Rencontre {
    @objid ("a9768312-82c1-4d3f-b94c-8acedd179618")
    private int idRencontre;

    @objid ("71af6a1e-d4f3-4e18-b0c7-9ac2eff4bb11")
    public int getIdRencontre() {
        return this.idRencontre;
    }

    @objid ("0b6d534b-c116-4d81-8d35-39d4cd452bf1")
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

    @objid ("345a9bd6-4f3e-483e-a71d-177e727740a5")
    public Equipe getVainqueur() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = "+ this.getIdRencontre() + " and a_gagne = 1");
        	rs.next();
        	int var = rs.getInt(1);
        	connex.close();
        	return new Equipe(var);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    @objid ("c0a8ba13-1b49-42bb-9c69-fac0810e18c5")
    public Equipe getPerdant() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = "+ this.getIdRencontre() + " and a_gagne = 0");
        	rs.next();
        	int var = rs.getInt(1);
        	connex.close();
        	return new Equipe(var);
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
        	rs.next();
        	Date result = rs.getDate(1);
        	connex.close();
        	return result;
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
