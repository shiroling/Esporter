package DBlink;

import java.util.List;

public class test {
	
	public static void main(String[] args) {
		List<Equipe> l = BDSelect.getListeEquipesFromTournoi(1);
		System.out.println(l);
		
	}
	
}
