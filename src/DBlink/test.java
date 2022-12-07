package DBlink;

import java.util.List;

public class test {
	
	public static void main(String[] args) {
		Rencontre re = new Rencontre(1);
		List<Equipe> eeee = re.getEquipes();
		
		System.out.println(eeee.get(0));
		System.out.println(eeee.get(1));
		
		
		
		
	}
	
}
