package SAE_Esporter.src;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import modeleBD.ControleurBD;
import modeleBD.Rencontre;
import modeleBD.Tournoi;

public class Test {

	@SuppressWarnings({ "deprecation", "unused" })
	public static void main(String[] args) {
		
		//List<Tournoi>  l = ControleurBD.getListeTournois();
		//List<Ecurie>  l = ControleurBD.getListeEcurie();
		//List<Equipe>  l = ControleurBD.getListeEquipes();
		//List<Jeu>  l = ControleurBD.getListeJeux();
		//List<Joueur>  l = ControleurBD.getListeJoueurs();
		//List<Poule>  l = ControleurBD.getListePoules();
		List<Rencontre>  l = ControleurBD.getListeRencontre();
		
		LocalDate d = LocalDate.of(1914, 6, 28);
		Date dfi = java.sql.Date.valueOf(LocalDate.of(1914, 6, 28));
		Date ddt = java.sql.Date.valueOf(LocalDate.of(1914, 7, 28));
		Date dft = java.sql.Date.valueOf(LocalDate.of(1918, 7, 28));
		Tournoi.insererTournoi("bébou", Portee.NATIONAL, dfi, ddt, dft, 1);
		
		
	}

}
