package DBlink;

import java.sql.ResultSet;
import java.sql.Statement;

import base.Portee;

public class BDinit {

	public static void initEcurie(Ecurie e) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select Nom_Ecurie, Nom_Manager, mdp_Manager from Ecurie where Id_Ecurie = " + e.getId());
			if(rs.next()) {
				e.setNom(rs.getString("Nom_Ecurie"));
				e.setNomManager(rs.getString("Nom_Manager"));
				e.setMdpManager(rs.getString("mdp_Manager"));
			}
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void initEquipe(Equipe e) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st
					.executeQuery("Select nom_Equipe, Id_Jeu, Id_Ecurie from Equipe where Id_Equipe = " + e.getId());
			rs.next();
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
			ResultSet rs = st.executeQuery(
					"Select nom, prenom, date_de_naissance, pseudo, id_equipe from Joueur where id_joueur = "
							+ j.getId());
			rs.next();
			j.setNom(rs.getString(1));
			j.setPrenom(rs.getString(2));
			j.setNaissance(rs.getDate(3));
			j.setPseudo(rs.getString(4));
			j.setIdEquipe(rs.getInt(5));
	
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void initJeu(Jeu j) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select nom_jeu from Jeu where Id_Jeu = " + j.getId());
			rs.next();
			j.setNom(rs.getString("nom_jeu"));
	
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void initPoule(Poule p) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select finale, id_tournoi from poule where Id_Equipe = " + p.getId());
			if (rs.getInt(0) > 0) {
				p.setIsFinale(true);
			} else {
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
			ResultSet rs = st.executeQuery(
					"Select NOM, PORTÉE, DATEFININSRIPTIONS, DATEDEBUTTOURNOI, DATEFINTOURNOI, ID_JEU, ID_GERANT from tournoi where Id_tournoi = "
							+ t.getId());
			rs.next();
			t.setNom(rs.getString(1));
			t.setDateFinInscriptions(rs.getDate(3));
			t.setDateDebut(rs.getDate(4));
			t.setDateFin(rs.getDate(5));
			t.setIdJeu(rs.getInt(6));
			t.setIdGerant(rs.getInt(7));
	
			String s = rs.getString(2);
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
				break;
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
			
			ResultSet rs = st
					.executeQuery("Select id_arbitre, id_poule, date_rencontre from rencontre where id_rencontre = " + r.getId());
			rs.next();
			r.setIdArbitre(rs.getInt("id_arbitre"));
			r.setIdPoule(rs.getInt("id_poule"));
			r.setDate(rs.getDate("date_rencontre"));
	
			st.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

}
