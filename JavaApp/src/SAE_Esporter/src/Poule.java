package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f982da88-61da-4117-ba1e-a5f9431697a8")
public class Poule {
    @objid ("412d63dc-3d9b-4fde-9d1e-6cd67d911448")
    private int idPoule;

    @objid ("78427808-9fb0-4d14-a33c-a3a37cd9ac42")
    public int getIdPoule() {
        return this.idPoule;
    }

    @objid ("e77a78a8-9c23-4837-8f16-113351f4e22d")
    public Poule(int idPoule) {
        this.idPoule = idPoule;
    }

    @objid ("84278edf-bbcc-4cad-ae60-307adf1fb14a")
    public boolean isPouleFinal() {
    	Connection connex = ConnexionBase.getConnection();
        try {
        	Statement st = connex.createStatement();
        	ResultSet rs = st.executeQuery("Select Final from Poule where id_Poule = "+ this.getIdPoule());
        	rs.next();
        	boolean result = rs.getBoolean(1);
        	connex.close();
        	return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
    }

}
