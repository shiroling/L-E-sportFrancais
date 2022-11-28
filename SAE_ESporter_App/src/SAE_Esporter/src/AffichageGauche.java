package SAE_Esporter.src;

import java.util.HashMap;
import java.util.Map;

import modeleBD.Equipe;
import modeleBD.Jeu;
import modeleBD.Rencontre;
import modeleBD.Tournoi;

public class AffichageGauche {
	private String[] valeursOption;
	private Map<Integer, String[]> valeursFilter;
	
	public AffichageGauche() {
		this.valeursOption = new String[] {"Tournois", "Equipes", "Jeux", "Matchs"};
		
		this.valeursFilter = new HashMap<>();
		this.valeursFilter.put(this.valeursOption[0].hashCode(), new String[] {"Tous","En cours", "Finis", "A venir"});
		this.valeursFilter.put(this.valeursOption[1].hashCode(), new String[] {"Tous"});
		this.valeursFilter.put(this.valeursOption[2].hashCode(), new String[] {"Tous"});
		this.valeursFilter.put(this.valeursOption[3].hashCode(), new String[] {"Tous","En cours", "Finis", "A venir"});
	}
	
	
	public static String[] getValeursFiltre(String selectedOption) {
		String[] valeursOption = new String[] {"Tournois", "Equipes", "Jeux", "Matchs"};
		Map<Integer, String[]> valeursFilter = new HashMap<>();
		valeursFilter.put(valeursOption[0].hashCode(), new String[] {"Tous","En cours", "Finis", "A venir"});
		valeursFilter.put(valeursOption[1].hashCode(), new String[] {"Tous"});
		valeursFilter.put(valeursOption[2].hashCode(), new String[] {"Tous"});
		valeursFilter.put(valeursOption[3].hashCode(), new String[] {"Tous","En cours", "Finis", "A venir"});
		return valeursFilter.get(selectedOption.hashCode());
	}
	
	public static String[] getListValues(String selectedOption, String selectedFilter) {
		switch (selectedOption) {
		case "Tournois":
			return AffichageGauche.selecteurRencontre(selectedFilter);
		case "Equipes":
			return Equipe.getStringEquipes();
		case "Jeux":
			return Jeu.getStringJeux();
		case"Matchs":
			return AffichageGauche.selecteurRencontre(selectedFilter);
		}
		return null;
	}


	private static String[] selecteurRencontre(String selectedFilter) {
		switch (selectedFilter) {
		case "Tous": 
			return Rencontre.getStringRencontre();
		case "Finis":
			return Rencontre.getStringRencontresFinis();
		case "A venir":
			return Rencontre.getStringRencontresAVenir();
		}
		return null;
	}


	private static String[] selecteurTournois(String selectedFilter) {
		switch (selectedFilter) {
		case "Tous": 
			return Tournoi.getStringTournois();
		case "En cours":
			return Tournoi.getStringTournoisEnCours();
		case "Finis":
			return Tournoi.getStringTournoisFinis();
		case "A venir":
			return Tournoi.getStringTournoisAVenir();
		}	
		return null;
	}
}