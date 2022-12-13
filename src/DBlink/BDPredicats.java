package DBlink;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import base.Portee;

public class BDPredicats {

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
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("Select Count(id_tournoi)as count from Tournoi where nom LIKE '%?%';");
			st.setString(0, nomTournoi);
			ResultSet rs = st.executeQuery();
			rs.next();
			boolean b  = rs.getInt("count") > 0;
			st.close();
			return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean existeGerant(int IdGerant){
	    try {
	        PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("Select count(nom) as count from Gerant where id_gerant = ?");
	        st.setInt(1, IdGerant);
	        
	        ResultSet rs = st.executeQuery();
	        rs.next();
	        boolean b  = rs.getInt(1) > 0;
			st.close();
			return b;
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return false;
	    }
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
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return false;
	    }
	}
	
	public static boolean estTournoiEnCours(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.datedebuttournoi < CURRENT_DATE AND tournoi.datefintournoi > CURRENT_DATE AND id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}
	
	public static boolean estTournoiFini(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.datefintournoi < CURRENT_DATE AND id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}
	
	public static boolean estTournoiAVenir(int id) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.datedebuttournoi > CURRENT_DATE AND id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}
	
	public static boolean sontInscriptionsFinies(int id) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT count(id_tournoi)as count FROM tournoi t WHERE t.datefininsriptions < CURRENT_DATE AND id_tournoi = ?");
	    	st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
	    	boolean check = rs.getInt("count") > 0;
			st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}

	
	public static boolean estTournoiSurJeu(int id, int idJeu) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.id_jeu = " + idJeu + " AND tournoi.id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}

	public static boolean estTournoiDePortee(int id, Portee p) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.portee = '" + p.getName() + "' AND tournoi.id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}

	public static boolean estTournoiMulti(Tournoi t) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT count(*) as count FROM tournoi t WHERE t.ID_TOURNOI = ? AND t.nom LIKE ? ");
	    	st.setInt(1, t.getId());
	    	st.setString(2, t.getNom().split("-")[0]+"%-%");
			ResultSet rs = st.executeQuery();
	    	rs.next();
	    	boolean check = rs.getInt("count") > 0;
	    	st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
	        return false;
		}
	}

	public static boolean estMatchSurJeu(int idMatch, int idJeu) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT tournoi.id_tournoi FROM tournoi t, poule p, rencontre r WHERE r.id_rencontre = " + idMatch + " AND r.id_poule = p.id_poule AND p.id_tournoi = t.id_tournoi");
	    	int idTournoi = rs.getInt(1);
	    	st.close();
	    	return estTournoiSurJeu(idTournoi, idJeu);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}

	public static boolean estMatchTournoi(int idMatch, int idTournoi) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT tournoi.id_tournoi FROM tournoi t, poule p, rencontre r WHERE r.id_rencontre = " + idMatch + " AND r.id_poule = p.id_poule AND p.id_tournoi = t.id_tournoi AND id_tournoi = " + idTournoi);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}
	
	public static boolean estMatchAvecEquipe(int idMatch, int idEquipe) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_equipe FROM jouer WHERE id_equipe = " + idEquipe + " AND id_rencontre = " + idMatch);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}

	public static boolean estMatchPoule(int idMatch, int idPoule) {
		try {
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_poule FROM rencontre WHERE id_rencontre = " + idMatch + " AND id_poule = " + idPoule);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}
	
		
	public static boolean estEquipeFromEcurie(Equipe equipe, Integer idEcurie) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT count(*) as count from Equipe Where id_ecurie = ?");
			st.setInt(1, idEcurie);
			ResultSet rs = st.executeQuery();
			
			rs.next();
	    	boolean check = rs.getInt("count") > 0;
			st.close();
	    	return check;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public static boolean estEquipeSurJeu(Equipe equipe, Integer idJeu) {
		try {
			PreparedStatement st = ConnexionBase.getConnectionBase().prepareStatement("SELECT COUNT(*) as count FROM EQUIPE e WHERE e.ID_JEU = ?");
			st.setInt(1, idJeu);
			ResultSet rs = st.executeQuery();
			
			rs.next();
	    	boolean check = rs.getInt("count") > 0;
			st.close();
	    	return check;
		} catch (Exception e) {			
			e.printStackTrace();
			return false;

		}
	}

	
}
