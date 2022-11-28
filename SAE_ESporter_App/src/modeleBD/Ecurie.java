package modeleBD;

import java.util.List;

public class Ecurie {
	private final int id;
	private String nom;
	private String nomManager;
	private String mdpManager;

	
	public Ecurie(int id) {
		super();
		this.id = id;
	}
	
	private void init() {
		ControleurBD.initEcurie(this);
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

	public String getNomManager() {
		if(this.nomManager == null) {
			this.init();
		}
		return nomManager;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	protected void setMdpManager(String mdpManager) {
		if(this.mdpManager == null) {
			this.init();
		}
		this.mdpManager = mdpManager;
	}

	protected void setNomManager(String nomManager) {
		if(this.nomManager == null) {
			this.init();
		}
		this.nomManager = nomManager;
	}

	public static String[] toStrings(List<Ecurie> l) {
		if(l.size() == 0) {
			return new String[] {"-- Aucun tournois dans la BD --"};
		}
		String[] result = new String[l.size()];
		for (int i = 0; i < l.size(); i++) {
			result[i] = l.get(i).toString();
		}
		return result;
	}


	@Override
	public String toString() {
		return ""+ this.getNom() +" ("+this.getNomManager()+ ")";
	}
	
}
