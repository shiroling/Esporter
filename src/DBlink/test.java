package DBlink;

import java.util.List;

public class test {
	
	public static void main(String[] args) {
		Jeu j = new Jeu(1);
		
		System.out.println(j);
		
		String sj = j.getNom();
		
		System.out.println(sj);
		
		String[] lsj = Jeu.toStrings();
		
		for (String string : lsj) {
			System.out.println(string);

		}
		
	}
	
}
