package DBlink;

import java.sql.CallableStatement;
import java.sql.Connection;
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
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.datefininscrtiptions < CURRENT_DATE AND id_tournoi = " + id);
	    	boolean check = rs.next();
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
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.portée = " + p.toString() + " AND tournoi.id_tournoi = " + id);
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}

	public static boolean estTournoiMulti(int id) {
		try {
			Tournoi t = new Tournoi(id);
			Statement st = ConnexionBase.getConnectionBase().createStatement();
	    	ResultSet rs = st.executeQuery("SELECT id_tournoi FROM tournoi WHERE tournoi.nom LIKE '" + t.getNom() + "%'");
	    	rs.next();
	    	boolean check = rs.next();
	    	st.close();
	    	return check;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}

	public static boolean estMatchSurJeu(int idMatch, int idTournoi) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean estMatchTournoi(int idMatch, int idTournoi) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean estMatchAvecEquipe(int idMatch, int idEquipe) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean estMatchPoule(int idMatch, int idPoule) {
		// TODO Auto-generated method stub
		return false;
	}


	public static boolean estEquipeFromEcurie(int idEquipe, int idEcurie) {
		// TODO Auto-generated method stub
		return false;
	}


	public static boolean estEquipeSurJeu(int idEquipe, int idJeu) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
