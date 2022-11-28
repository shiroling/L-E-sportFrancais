package modeleBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
	private final int id;
	private String nom;
	private int idJeu;
	private int idEcurie;
	
	public Equipe(int id) {
		super();
		this.id = id;
		this.idJeu = -1;
		this.idEcurie = -1;
	}

	private void init() {
		ControleurBD.initEquipe(this);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}


	public void setIdEcurie(int idEcurie) {
		this.idEcurie = idEcurie;
	}


	public int getId() {
		return id;
	}

	public String getNom() {
		if(this.nom == null) {
			this.init();
		}
		return nom;
	}

	public int getIdJeu() {
		if(this.idJeu == -1) {
			this.init();
		}
		return idJeu;
	}

	public int getIdEcurie() {
		if(this.idEcurie == -1) {
			this.init();
		}
		return idEcurie;
	}
	
	public List<Joueur> getListJoueur() {
		return ControleurBD.getListeJoueursFromEquipe(getId());
	}

	public static List<Equipe> getToutesLesEquipes() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_Equipe from Equipe");
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

	public static String[] getStringEquipes() {
		List<Equipe> equipes = Equipe.getToutesLesEquipes();
		String[] nomEquipes = new String[equipes.size()];
		for(int i = 0; i < equipes.size() ; i++) {
			nomEquipes[i] = equipes.get(i).toString();
		}
		return nomEquipes;
	}

	@Override
	public String toString() {
		return this.getNom();
	}

}
