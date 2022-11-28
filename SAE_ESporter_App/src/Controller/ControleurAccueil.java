package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ConnexionUtilisateur.ConnexionState;
import IHM.Accueil;
import IHM.CreerTournoi;
import IHM.Test;

public class ControleurAccueil implements ActionListener{

	private Etat state;
	private Test vueAccueil;
	private JButton btn;
	private ConnexionUtilisateur.ConnexionState connexionState;

	public ControleurAccueil(Test vueAccueil) {
		this.state = Etat.ACCUEIL_SANS_VOLET;
		this.vueAccueil = vueAccueil;
		connexionState = ConnexionState.NON_CONNECTE;
	}

	private enum Etat {
		ACCUEIL_SANS_VOLET, ACCUEIL_AVEC_VOLET, CONNEXION, FORMULAIRE;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		btn = (JButton) e.getSource();
		switch (this.state) {
		case ACCUEIL_SANS_VOLET :
			switch (btn.getText()) {
			case "Creer Tournoi" :
				procedureCreerTournoi();
				break;
			}
		case ACCUEIL_AVEC_VOLET :
			break;
		case CONNEXION :
			break;
		case FORMULAIRE :
			break;
		}

	}

	public void setConnexionState(ConnexionUtilisateur.ConnexionState c) {
		this.connexionState = c;
	}

	private void procedureCreerTournoi() {
		if(connexionState != ConnexionUtilisateur.ConnexionState.GESTIONNAIRE) {
			this.state = Etat.CONNEXION;
			IHM.Connexion fenetreConnnexion = new IHM.Connexion(this, ConnexionState.GESTIONNAIRE);
			this.state = Etat.ACCUEIL_SANS_VOLET;
		} 
		if(connexionState == ConnexionUtilisateur.ConnexionState.GESTIONNAIRE) {
			this.state = Etat.FORMULAIRE;
			CreerTournoi formTournoi = new CreerTournoi();
			this.state = Etat.ACCUEIL_SANS_VOLET;
		}
	}

}
