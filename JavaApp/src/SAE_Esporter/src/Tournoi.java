package SAE_Esporter.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("Select Nom from Tournoi where id_tournoi = "+ this.getIdTournoi());
			rs.next();
			String result = rs.getString(1);
			rs.close();
			st.close();
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@objid ("dfcb7550-2bfe-4669-894e-0bdcc5e6501f")
	public List<Equipe> getListEquipesParticipantes() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("Select id_equipe from incrit where id_Tournoi = "+ this.getIdTournoi());

			List<Equipe> equipes = new ArrayList<>();
			while(rs.next()) {
				equipes.add(new Equipe(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return equipes;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	public static List<Tournoi> getTousLesTournois() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_tournoi from tournoi");
			List<Tournoi> tournois = new ArrayList<>();
			while(rs.next()) {
				tournois.add(new Tournoi(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return tournois;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static String[] getStringTournois() {
		List<Tournoi> tournois = Tournoi.getTousLesTournois();
		if(tournois.size() == 0) {
			return new String[] {"-- Aucun --"};
		}
		String[] nomTournois = new String[tournois.size()];
		for(int i = 0; i < tournois.size() ; i++) {
			nomTournois[i] = tournois.get(i).toString();
		}
		return nomTournois;
	}

	public Date getDateInscriptionEquipe(Equipe equipe) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("Select dateInscription from inscrit where id_tournoi = "+ this.getIdTournoi() + " and id_equipe = " + equipe.getIdEquipe());
			rs.next();
			Date result = rs.getDate(1);
			rs.close();
			st.close();
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public String toString() {
		return this.getNomTournoi();
	}
	
	public static List<Tournoi> getTournoisEnCours() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_tournoi FROM Tournoi where DateDebutTournoi <= date() and DateFinTournoi > getDate()");
			List<Tournoi> tournois = new ArrayList<>();
			while(rs.next()) {
				tournois.add(new Tournoi(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return tournois;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Tournoi> getTournoisFinis() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_tournoi FROM Tournoi where DateFinTournoi < Date()");
			List<Tournoi> tournois = new ArrayList<>();
			while(rs.next()) {
				tournois.add(new Tournoi(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return tournois;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Tournoi> getTournoisAVenir() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_tournoi FROM Tournoi where DateDebutTournoi > Date()");
			List<Tournoi> tournois = new ArrayList<>();
			while(rs.next()) {
				tournois.add(new Tournoi(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return tournois;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static String[] getStringTournoisEnCours() {
		List<Tournoi> tournois = Tournoi.getTournoisEnCours();
		if(tournois.size() == 0) {
			return new String[] {"-- Aucun --"};
		}
		String[] strTournois = new String[tournois.size()];
		for(int i = 0; i < tournois.size(); i++) {
			strTournois[i] = tournois.get(i).toString();
		}
		return strTournois;
	}

	public static String[] getStringTournoisFinis() {
		List<Tournoi> tournois = Tournoi.getTournoisFinis();
		if(tournois.size() == 0) {
			return new String[] {"-- Aucun --"};
		}
		String[] strTournois = new String[tournois.size()];
		for(int i = 0; i < tournois.size(); i++) {
			strTournois[i] = tournois.get(i).toString();
		}
		return strTournois;
	}

	public static String[] getStringTournoisAVenir() {
		List<Tournoi> tournois = Tournoi.getTournoisAVenir();
		if(tournois.size() == 0) {
			return new String[] {"-- Aucun --"};
		}
		String[] strTournois = new String[tournois.size()];
		for(int i = 0; i < tournois.size(); i++) {
			strTournois[i] = tournois.get(i).toString();
		}
		return strTournois;
	}
	
	public static void insererTournoi(String nomTounoi, String porteeTournoi, String dateFinInscription, String dateDebutTournoi, String dateFinTournoi, int idJeu) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Tournoi values (Seq_Tournoi.nextVal, ?,?,TO_DATE(?, 'DD/MM/YYYY'),TO_DATE(?, 'DD/MM/YYYY'),TO_DATE(?, 'DD/MM/YYYY'),?, 1)");
			st.setString(1, nomTounoi);
			st.setString(2, porteeTournoi);
			st.setString(3, dateFinInscription);
			st.setString(4, dateDebutTournoi);
			st.setString(5, dateFinTournoi);
			st.setInt(6, idJeu);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
