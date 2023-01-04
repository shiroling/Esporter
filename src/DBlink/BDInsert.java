package DBlink;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import base.Portee;

public class BDInsert {

	protected static void insererTournoi(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, int idJeu, int idGerant) {
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
	
	protected static void insererPoule(int idTournoi, List<Equipe> listeEquipes) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Poule values (Seq_Poule.nextVal, 0, ?)");
			st.setInt(1, idTournoi);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for(Equipe e : listeEquipes) {
			try {
				PreparedStatement st = connex.prepareStatement("Insert into Composer values (Seq_Poule.currval, ?)");
				st.setInt(1, e.getId());
				st.executeUpdate();
			} catch (Exception ee) {
				System.out.println(ee.getMessage());
			}
		}
	}
	
	protected static void insererPouleFinale(int idTournoi) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Poule values (Seq_Poule.nextVal, 1, ?)");
			st.setInt(1, idTournoi);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	protected static void insererRencontre(int idArbitre, int idPoule, Date dateRencontre, List<Equipe> listeEquipes) {
		Connection connex = ConnexionBase.getConnectionBase();
		try {
			PreparedStatement st = connex.prepareStatement("Insert into Rencontre values (Seq_Rencontre.nextVal, ?, ?, ?)");
			st.setInt(1, idArbitre);
			st.setInt(2, idPoule);
			st.setDate(3, dateRencontre);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for(Equipe e : listeEquipes) {
			try {
				PreparedStatement st = connex.prepareStatement("Insert into Jouer values (?, Seq_Poule.currval, null)");
				st.setInt(1, e.getId());
				st.executeUpdate();
			} catch (Exception ee) {
				System.out.println(ee.getMessage());
			}
		}
	}
	
}
