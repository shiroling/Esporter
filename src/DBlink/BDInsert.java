package DBlink;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import base.Portee;

public class BDInsert {

	public static void insererTournoi(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, int idJeu, int idGerant) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Tournoi values (Seq_Tournoi.nextVal, ?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, nomTounoi);
			st.setString(2, porteeTournoi.getName());
			st.setDate(3, dateFinInscription);
			st.setDate(4, dateDebutTournoi);
			st.setDate(5, dateFinTournoi);
			st.setInt(6, idJeu);
			st.setInt(7, idGerant);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
