package SAE_Esporter.src;

import java.util.List;

import modeleBD.ControleurBD;
import modeleBD.Ecurie;
import modeleBD.Equipe;
import modeleBD.Jeu;
import modeleBD.Joueur;
import modeleBD.Poule;
import modeleBD.Rencontre;
import modeleBD.Tournoi;

public class Test {

	public static void main(String[] args) {
		
		//List<Tournoi>  l = ControleurBD.getListeTournois();
		//List<Ecurie>  l = ControleurBD.getListeEcurie();
		//List<Equipe>  l = ControleurBD.getListeEquipes();
		//List<Jeu>  l = ControleurBD.getListeJeux();
		//List<Joueur>  l = ControleurBD.getListeJoueurs();
		//List<Poule>  l = ControleurBD.getListePoules();
		List<Rencontre>  l = ControleurBD.getListeRencontre();
		
		

		for(Tournoi t : l) {
			System.out.println(t);
		}
	}

}
