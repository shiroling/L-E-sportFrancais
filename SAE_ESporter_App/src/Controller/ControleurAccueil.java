package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ConnexionUtilisateur.ConnexionState;
import IHM.AccueilV2;
import IHM.CreerTournoi;
import modeleBD.ControleurBD;

public class ControleurAccueil implements ActionListener {

	private Etat state;
	private AccueilV2 vue;
	private Object obj;
	private JButton btn;
	private ConnexionUtilisateur.ConnexionState connexionState;

	public ControleurAccueil(AccueilV2 vue) {
		this.state = Etat.ACCUEIL_SANS_VOLET;
		this.vue = vue;
		connexionState = ConnexionState.NON_CONNECTE;
	}

	private enum Etat {
		ACCUEIL_SANS_VOLET, ACCUEIL_AVEC_VOLET, CONNEXION, FORMULAIRE;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		obj =  e.getSource();
		if (obj instanceof JButton) {
			btn = (JButton) obj;
			switch (this.state) {
			case ACCUEIL_SANS_VOLET:
				switch (btn.getText()) {
				case "Creer Tournoi":
					procedureCreerTournoi();
					break;
				case "Tournois":
					vue.viderCartes();
					vue.ajouterCartesTournois(ControleurBD.getListeTournois());
					break;
				case "Match":
					vue.viderCartes();
					vue.ajouterCartesMatch(ControleurBD.getListeRencontre());
					break;
				case "Jeu":
					vue.viderCartes();
					vue.ajouterCartesJeu(ControleurBD.getListeJeux());
					break;
				case"Equipe":
					vue.viderCartes();
					vue.ajouterCartesEquipe(ControleurBD.getListeEquipes());
					break;
				case"Ecurie":
					vue.viderCartes();
					vue.ajouterCartesEcurie(ControleurBD.getListeEcurie());
					break;
				}
			case ACCUEIL_AVEC_VOLET:
				break;
			case CONNEXION:
				break;
			case FORMULAIRE:
				break;
			}

		}
		
	}

	public void setConnexionState(ConnexionUtilisateur.ConnexionState c) {
		this.connexionState = c;
	}

	private void procedureCreerTournoi() {
		if (connexionState != ConnexionUtilisateur.ConnexionState.GESTIONNAIRE) {
			this.state = Etat.CONNEXION;
			IHM.Connexion fenetreConnnexion = new IHM.Connexion(this, ConnexionState.GESTIONNAIRE);
			this.state = Etat.ACCUEIL_SANS_VOLET;
		}
		if (connexionState == ConnexionUtilisateur.ConnexionState.GESTIONNAIRE) {
			this.state = Etat.FORMULAIRE;
			CreerTournoi formTournoi = new CreerTournoi();
			this.state = Etat.ACCUEIL_SANS_VOLET;
		}
	}

}
