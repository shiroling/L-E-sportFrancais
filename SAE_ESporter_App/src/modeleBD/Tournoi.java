package modeleBD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import SAE_Esporter.src.Portee;

public class Tournoi {
	private int id;
	private String nom;
	private Portee portee;
	private Date dateFinInscriptions;
	private Date dateDebut;
	private Date dateFin;
	private int idJeu;
	private int idGerant;
	
	public Tournoi(int id) {
		super();
		this.id = id;
		this.nom = null;
		this.portee = null;
		this.dateFinInscriptions = null;
		this.dateDebut = null;
		this.dateFin = null;
		this.idJeu = -1;
		this.idGerant = -1;
	}
	
	
	private void init() {
		ControleurBD.initTournoi(this);
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		if(nom == null) {
			this.init();
		}
		return nom;
	}
	
	public Portee getPortee() {
		if(this.portee == null) {
			this.init();
		}
		return portee;
	}

	public Date getDateFinInscriptions() {
		if(this.dateFinInscriptions == null) {
			this.init();
		}
		return dateFinInscriptions;
	}

	public Date getDateDebut() {
		if(this.dateDebut == null) {
			this.init();
		}
		return dateDebut;
	}
	
	public Date getDateFin() {
		if(this.dateFin == null) {
			this.init();
		}
		return dateFin;
	}

	public int getIdJeu() {
		if(this.idJeu == -1) {
			this.init();
		}
		return idJeu;
	}


	public int getIdGerant() {
		if(this.idGerant == -1) {
			this.init();
		}
		return idGerant;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	protected void setPortee(Portee portee) {
		this.portee = portee;
	}

	protected void setDateFinInscriptions(Date dateFinInscriptions) {
		this.dateFinInscriptions = dateFinInscriptions;
	}

	protected void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	protected void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	protected void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}

	protected void setIdGerant(int idGerant) {
		this.idGerant = idGerant;
	}

	public List<Equipe> getListEquipesParticipantes() {
		return ControleurBD.getListeEquipesFromTournoi(this.getId());
	}

	public static String[] toStrings(List<Tournoi> l) {
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
		return this.getNom();
	}
	
	public Date getDateInscriptionEquipe(int idEquipe) {
		return ControleurBD.getDateInscriptionEquipe(this.getId(), idEquipe);
	}
	
	public static List<Tournoi> getTournoisEnCours() {
		return ControleurBD.getTournoisEnCours();
	}
	
	public static List<Tournoi> getTournoisFinis() {
		return ControleurBD.getTournoisFinis();
	}
	
	public static List<Tournoi> getTournoisAVenir() {
		return ControleurBD.getTournoisAVenir();
	}
	
	public static void insererTournoi(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, int idJeu) throws IllegalArgumentException {
		if(!isValidNom(nomTounoi)) {
			throw new IllegalArgumentException("Le nom donné au tournoi est déjà pris");
		}
		
		if(!isValidDates(dateFinInscription, dateDebutTournoi, dateFinTournoi)) {
			throw new IllegalArgumentException("Les dates données ne corélent pas");
		}		
		ControleurBD.insererTournoi(nomTounoi, porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinInscription, idJeu);
	}
	
	public static void insérerTournoisMultigaming(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, int idJeu[]) {
		// TODO Implémenter cette méthode SVP
	}
	
	public static boolean isValidToInsert(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, int idJeu) {
		return isValidNom(nomTounoi) && isValidDates(dateFinInscription, dateDebutTournoi, dateFinTournoi);
	}


	private static boolean isValidDates(Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi) {
		return dateFinInscription.before(dateDebutTournoi) && dateDebutTournoi.before(dateFinTournoi);
	}

	private static boolean isValidNom(String nomTounoi) {
		return !ControleurBD.existeNomTournoi(nomTounoi);
	}
	
	

	

	

}
