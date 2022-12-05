package modeleBD;

import java.sql.Date;
import java.util.List;

public class Rencontre {
	private final int id;
	private int idArbitre;
	private int idPoule;
	private Date date;

	public Rencontre(int id) {
		super();
		this.id = id;
		this.idArbitre = -1;
		this.idPoule = -1;
	}
	
	private void init() {
		ControleurBD.initRencontre(this);
	}
	
	public Date getDate() {
		if(date == null) {
			this.init();
		}
		return date;
	}	

	protected void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public int getIdArbitre() {
		if(idArbitre == -1) {
			this.init();
		}
		return idArbitre;
	}

	public int getIdPoule() {
		if(idPoule == -1) {
			this.init();
		}
		return idPoule;
	}

	protected void setIdArbitre(int idArbitre) {
		this.idArbitre = idArbitre;
	}

	protected void setIdPoule(int idPoule) {
		this.idPoule = idPoule;
	}

	public List<Equipe> getEquipes() {
		return ControleurBD.getEquipesFromRencontre(this.getId());
	}

	public Equipe getVainqueur() throws IllegalArgumentException {
		if(estResultatRenseigne()) {
			throw new IllegalArgumentException("Le résultat de la rencontre n'as pas été renseigné");
		}
		return ControleurBD.getVainqueurRencontre(getId());
	}

	public Equipe getPerdant() {
		if(estResultatRenseigne()) {
			throw new IllegalArgumentException("Le résultat de la rencontre n'as pas été renseigné");
		}
		return ControleurBD.getPerdantRencontre(id);
	}
	
	public boolean estResultatRenseigne() {
		return ControleurBD.estResultatRenseigne(getId());
	}
	
	public Poule getArbitre() {
		return new Poule(this.idPoule);
	}
	
	public boolean isArbitreRencontre(int idArbitre) {
		return idArbitre == this.idArbitre;
	}

	public static String[] toStrings(List<Rencontre> l) {
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
		return " [ " + this.getEquipes().get(0) + " / " + this.getEquipes().get(1) + " ] ";
	}

	

}
