
package commun;

import java.util.stream.Stream;

public enum Portee {
	LOCAL("Local"), 
	NATIONAL("National"),
	INTERNATIONAL("International");
	
	private final String name;

	private Portee(String s) {
		name = s;
	}
	
	public static String[] toStrings() {
		String[] portees = {LOCAL.getName(), NATIONAL.getName(), INTERNATIONAL.getName()};
		return portees;
	}
	
	public static Portee stringToPortee(String str) {
		switch(str) {
			case "Local":
				return Portee.LOCAL;
			case "National":
				return Portee.NATIONAL;
			case "International" :
				return Portee.INTERNATIONAL;
			default :
				return null;
		}
	}
	
	public String getName() {
		return name;
	}
}