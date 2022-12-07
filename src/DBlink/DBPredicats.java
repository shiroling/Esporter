package DBlink;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class DBPredicats {

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

}
