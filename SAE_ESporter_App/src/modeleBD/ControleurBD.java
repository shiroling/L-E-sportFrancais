package modeleBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import SAE_Esporter.src.ConnexionBase;
import SAE_Esporter.src.Portee;

public class ControleurBD {

	public ControleurBD(Connection connex) {
		super();
	}
	
	public static void initEcurie(Ecurie e) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select Nom_Ecurie, Nom_Manager, mdp_Manager from Ecurie where Id_Ecurie = "+ e.getId());

			e.setNom(rs.getString(1));
			e.setMdpManager(rs.getString(2));
			e.setNomManager(rs.getString(3));
			
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}	
	}
	
	public static void initEquipe(Equipe e) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select nom_Equipe, Id_Jeu, Id_Ecurie from Equipe where Id_Equipe = "+ e.getId());

			e.setNom(rs.getString(1));
			e.setIdJeu(rs.getInt(2));
			e.setIdEcurie(rs.getInt(3));
			
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}	
	}
		
	public static void initJoueur(Joueur j) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select nom, prenom, date_de_naissance, pseudo, id_equipe from Equipe where Id_Equipe = "+ j.getId());

			j.setNom(rs.getString(0));
			j.setPrenom(rs.getString(1));
			j.setNaissance(rs.getDate(2));
			j.setPseudo(rs.getString(3));
			j.setIdEquipe(rs.getInt(4));

			
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}	
	}
	
	public static void initJeu(Jeu j) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select nom_jeu from Equipe where Id_Equipe = "+ j.getId());

			j.setNom(rs.getString(0));
			
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void initPoule(Poule p) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select finale, id_tournoi from poule where Id_Equipe = "+ p.getId());
			if(rs.getInt(0) > 0) {
				p.setIsFinale(true);
			}else {
				p.setIsFinale(false);
			}
			
			p.setIdTournoi(rs.getInt(1));
			
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	public static void initTournoi(Tournoi t) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select 	NOM, PORTÉE, DATEFININSRIPTIONS, DATEDEBUTTOURNOI, DATEFINTOURNOI, ID_JEU, ID_GERANT "
					+ "from poule where Id_Equipe = "+ t.getId());
			
			t.setNom(rs.getString(0));
			t.setDateFinInscriptions(rs.getDate(2));
			t.setDateDebut(rs.getDate(3));
			t.setDateFin(rs.getDate(4));
			t.setIdJeu(rs.getInt(5));
			t.setIdGerant(rs.getInt(6));
			
			String s = rs.getString(1);
			switch (s) {
				case "Local": {
					t.setPortee(Portee.LOCAL);
					break;
				}
				case "International": {
					t.setPortee(Portee.INTERNATIONAL);
					break;
				}
				case "National": {
					t.setPortee(Portee.NATIONAL);
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + s);
			}		
			
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void initRencontre(Rencontre r) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select 	id_arbitre, id_poule from rencontre where id_rencontre = "+ r.getId());
			
			r.setIdArbitre(rs.getInt(0));
			r.setIdPoule(rs.getInt(1));		
			
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

		
	
	public static List<Joueur> getListeJoueurs() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_Joueur from Joueur");
	
			List<Joueur> joueurs = new ArrayList<>();
			while(rs.next()) {
				joueurs.add(new Joueur(rs.getInt(1)));
			}
			st.close();
			return joueurs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Equipe> getListeEquipes() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe from equipe");
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

	public static List<Jeu> getListeJeux() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_Jeu from Jeu");
			List<Jeu> jeux = new ArrayList<>();
			while(rs.next()) {
				jeux.add(new Jeu(rs.getInt(1)));
			}
			st.close();
			return jeux;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Tournoi> getListeTournois() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_tournoi from tournoi");
	
			List<Tournoi> t = new ArrayList<>();
			while(rs.next()) {
				t.add(new Tournoi(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Rencontre> getListeRencontre() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_tournoi from tournoi");
	
			List<Rencontre> t = new ArrayList<>();
			while(rs.next()) {
				t.add(new Rencontre(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Rencontre> getListeRencontreFromPoule( int idPoule) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_tournoi from tournoi WHERE id_Poule = " + idPoule);
	
			List<Rencontre> t = new ArrayList<>();
			while(rs.next()) {
				t.add(new Rencontre(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Rencontre> getRencontresAVenir() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_Rencontre FROM Rencontre where Date_Rencontre > getDate()");
			List<Rencontre> rencontres = new ArrayList<>();
			while(rs.next()) {
				rencontres.add(new Rencontre(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return rencontres;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Rencontre> getRencontresPassees() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_Rencontre FROM Rencontre where Date_Rencontre < getDate()");
			List<Rencontre> rencontres = new ArrayList<>();
			while(rs.next()) {
				rencontres.add(new Rencontre(rs.getInt(1)));
			}
			rs.close();
			st.close();
			return rencontres;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}	
	
	public static List<Joueur> getListeJoueursFromEquipe(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_Joueur from Joueur WHERE ID_EQUIPE = " + id);
	
			List<Joueur> joueurs = new ArrayList<>();
			while(rs.next()) {
				joueurs.add(new Joueur(rs.getInt(1)));
			}
			st.close();
			return joueurs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Equipe> getListeEquipesFromEcurie(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe from Equipe WHERE id_Ecurie = " + id);
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

	public static List<Equipe> getListeEquipesFromTournoi(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe from inscrit WHERE id_tournoi = " + id);
			List<Equipe> equipes = new ArrayList<>();
			while(rs.next()) {
				equipes.add(new Equipe(rs.getInt(1)));
			}
			st.close();
			return equipes;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Equipe> getListeEquipesFromPoule(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe from Composer WHERE id_poule = " + id);
			List<Equipe> equipes = new ArrayList<>();
			while(rs.next()) {
				equipes.add(new Equipe(rs.getInt(1)));
			}

			st.close();
			return equipes;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Equipe> getEquipesFromRencontre(int idRencontre) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = "+ idRencontre);

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

	public static Date getDateInscriptionEquipe(int idTournoi, int idEquipe) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("Select dateInscription from inscrit where id_tournoi = "+ idTournoi + " and id_equipe = " + idEquipe);
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

	public static List<Tournoi> getTournoisEnCours() {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			Statement st = connex.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_tournoi FROM Tournoi where DateDebutTournoi <= date() and DateFinTournoi >= getDate()");
			List<Tournoi> tournois = new ArrayList<>();
			while(rs.next()) {
				tournois.add(new Tournoi(rs.getInt(1)));
			}
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
	
	public static Equipe getVainqueurRencontre( int idRencontre) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = "+ idRencontre + " and a_gagne = 1");
			rs.next();
			int var = rs.getInt(1);
			rs.close();
			st.close();
			return new Equipe(var);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static Equipe getPerdantRencontre(int idRencontre) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = "+ idRencontre + " and a_gagne = O");
			rs.next();
			int var = rs.getInt(1);
			rs.close();
			st.close();
			return new Equipe(var);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static boolean estResultatRenseigne(int idRencontre) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = "+ idRencontre + " and a_gagne = 0");
			boolean check = rs.next();
			st.close();
			if (check) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}