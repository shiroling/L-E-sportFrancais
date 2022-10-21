package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fb2d8e6d-a4cd-49ce-b634-679c51da9295")
public class Ecurie {
    @objid ("774cb914-5c6e-421e-943d-1368b260a11d")
    private int idEcurie;

    @objid ("2d01e599-67af-4fea-8ea5-4a435ca3918a")
    public int getIdEcurie() {
        return this.idEcurie;
    }

    @objid ("4f405bc7-9d33-447f-af6e-6edebdf82a42")
    public Ecurie(int idEcurie) {
        this.idEcurie = idEcurie;
    }

    @objid ("71273bd2-0f55-46eb-98bc-474106e17d0c")
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

    @objid ("b31fa832-ae71-4f45-a074-56b2a1b3a757")
    public String getNomEcurie() {
        Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom_ecurie from Ecurie where id_Ecurie = "+ this.getIdEcurie());
        	rs.next();
        	String result = rs.getString(1);
        	connex.close();
        	return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    @objid ("bced1caf-5122-4b6f-9a82-767fe4768d09")
    public String getNomManager() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Nom_manager from Ecurie where id_Ecurie = "+ this.getIdEcurie());
        	rs.next();
        	String result = rs.getString(1);
        	connex.close();
        	return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    @Override
    public String toString() {
    	return ""+ this.getNomEcurie() +" ("+this.getNomManager()+ ")";
    }
}
