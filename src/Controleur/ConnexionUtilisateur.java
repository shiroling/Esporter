package Controleur;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBlink.ConnexionBase;

public class ConnexionUtilisateur {
	
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
	
	public static boolean isManager(String id, String mdp) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			CallableStatement st = connex.prepareCall("{? = call IS_MANAGER (?, ?)}");
			st.registerOutParameter(1, java.sql.Types.VARCHAR);
			st.setString(2, id);
			st.setString(3, mdp);
			ResultSet rs = st.executeQuery();
			rs.next();
			return (rs.getInt(1) == 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
