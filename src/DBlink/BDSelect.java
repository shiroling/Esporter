package DBlink;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class BDSelect {

	public BDSelect(Connection connex) {
		super();
	}

	public static List<Poule> getListePoules() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_Poule from Poule");

			List<Poule> l = new ArrayList<>();
			while (rs.next()) {
				l.add(new Poule(rs.getInt(1)));
			}
			st.close();
			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Joueur> getListeJoueurs() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_Joueur from Joueur");

			List<Joueur> joueurs = new ArrayList<>();
			while (rs.next()) {
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
			while (rs.next()) {
				equipes.add(new Equipe(rs.getInt("id_equipe")));
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
			while (rs.next()) {
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
			while (rs.next()) {
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
			ResultSet rs = st.executeQuery("Select id_rencontre from rencontre");

			List<Rencontre> t = new ArrayList<>();
			while (rs.next()) {
				t.add(new Rencontre(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Ecurie> getListeEcurie() {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_ecurie from ecurie");

			List<Ecurie> t = new ArrayList<>();
			while (rs.next()) {
				t.add(new Ecurie(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Rencontre> getListeRencontreFromPoule(int idPoule) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_rencontre from rencontre WHERE id_Poule = " + idPoule);

			List<Rencontre> t = new ArrayList<>();
			while (rs.next()) {
				t.add(new Rencontre(rs.getInt(1)));
			}
			st.close();
			return t;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Rencontre> getListeRencontreFromEquipe(int idEquipe) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_rencontre from rencontre, composer WHERE composer.id_equipe = " + idEquipe + "AND composer.id_poule = rencontre.id_poule");

			List<Rencontre> t = new ArrayList<>();
			while (rs.next()) {
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
			while (rs.next()) {
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
			while (rs.next()) {
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
			while (rs.next()) {
				joueurs.add(new Joueur(rs.getInt(1)));
			}
			st.close();
			return joueurs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static int getPointsEquipe(int idEquipe) {
		try {
			int points = 0;
			List<Rencontre> listeMatchs = BDSelect.getListeRencontreFromEquipe(idEquipe);
			for (Rencontre r : listeMatchs) {
				Statement st = ConnexionBase.getConnectionBase().createStatement();
				ResultSet rs = st.executeQuery("Select id_tournoi from rencontre r, poule p WHERE r.id_rencontre = " + r.getId() + " AND r.id_poule = p.id_poule;");
				Tournoi t = new Tournoi(rs.getInt(1));
				if (r.getVainqueur().getId() == idEquipe) {
					switch (t.getPortee()) {
					case LOCAL:
						points += 1;
						break;
					case NATIONAL:
						points += 2;
						break;
					case INTERNATIONAL:
						points += 3;
						break;
					}
				}
			}
			return points;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public static int getAgeMoyenEquipe(int idEquipe) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select round(avg(CURRENT_DATE - DATE_DE_NAISSANCE)/365.25) FROM Joueur WHERE ID_EQUIPE = " + idEquipe);
			st.close();
			return rs.getInt(1);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public static List<Equipe> getListeEquipesFromEcurie(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("SELECT id_equipe from Equipe WHERE id_Ecurie = " + id);
			List<Equipe> equipes = new ArrayList<>();
			while (rs.next()) {
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
			while (rs.next()) {
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
			while (rs.next()) {
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
			ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = " + idRencontre);

			List<Equipe> equipes = new ArrayList<>();
			while (rs.next()) {
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
			ResultSet rs = st.executeQuery("Select dateInscription from inscrit where id_tournoi = " + idTournoi
					+ " and id_equipe = " + idEquipe);
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
			ResultSet rs = st.executeQuery(
					"SELECT id_tournoi FROM Tournoi where DateDebutTournoi <= date() and DateFinTournoi >= getDate()");
			List<Tournoi> tournois = new ArrayList<>();
			while (rs.next()) {
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
			while (rs.next()) {
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
			ResultSet rs = st.executeQuery("SELECT id_tournoi FROM Tournoi where DateDebutTournoi > CURRENT_DATE");
			List<Tournoi> tournois = new ArrayList<>();
			while (rs.next()) {
				tournois.add(new Tournoi(rs.getInt("id_tournoi")));
			}
			rs.close();
			st.close();
			return tournois;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static Equipe getVainqueurRencontre(int idRencontre) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery(
					"Select id_equipe from Jouer where id_Rencontre = " + idRencontre + " and a_gagne = 1");
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
			ResultSet rs = st.executeQuery(
					"Select id_equipe from Jouer where id_Rencontre = " + idRencontre + " and a_gagne = O");
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

	public static String getNomJeu(int idJeu) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select nom_jeu from Jeu where id_Jeu = " + idJeu);
			rs.next();
			String var = rs.getString(1);
			rs.close();
			st.close();
			return var;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static int getIdJeu(String nomJeu) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_jeu from Jeu where nom_jeu = " + nomJeu);
			rs.next();
			int var = rs.getInt(1);
			rs.close();
			st.close();
			return var;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public static boolean estResultatRenseigne(int idRencontre) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_equipe from Jouer where id_Rencontre = " + idRencontre + " and a_gagne = 1");
			boolean check = rs.next();
			st.close();
			if (check) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean existeNomTournoi(String nomTournoi) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select id_tournoi from Tournoi where nom = '" + nomTournoi + "'");
			boolean check = rs.next();
			st.close();
			if (check) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
	
	public static boolean existeGerant(int IdGerant) {
        try {
            Statement st = ConnexionBase.getConnectionBase().createStatement();
            ResultSet rs = st.executeQuery("Select nom from Gerant where id_gerant = "+ IdGerant);
            boolean check = rs.next();
            st.close();
            if (check) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

	public static boolean isGestionnaire(String id, String mdp) {
        Connection connex = ConnexionBase.getConnectionBase();
        try {
            CallableStatement st = connex.prepareCall("{? = call IS_GESTIONNAIRE (?, ?)}");
            st.registerOutParameter(1, java.sql.Types.INTEGER);
            st.setString(2, id);
            st.setString(3, mdp);
            st.execute();
            System.out.println(st.getInt(1));
            return (st.getInt(1) == 1);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isManager(String nom, String mdp) {
        try {
        	Statement st = ConnexionBase.getConnectionBase().createStatement();
        	ResultSet rs = st.executeQuery("SELECT id_ecurie FROM Ecurie where nom_manager = '"+ nom +"' AND mdp_manager = '" + mdp + "'");
            return (rs.next());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public String getNomArbitre(int idArbitre) {
    	try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
			ResultSet rs = st.executeQuery("Select nom from Arbitre where id_arbitre = " + idArbitre);
			rs.next();
			String var = rs.getString(1);
			rs.close();
			st.close();
			return var;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }    
  
}
