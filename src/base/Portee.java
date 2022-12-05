package base;

import java.util.stream.Stream;

public enum Portee {
	LOCAL("Local"), 
	NATIONAL("National"),
	INTERNATIONAL("International");
	
	private final String name;

	Portee(String s) {
		name = s;
	}
	
	public static String[] toStrings() {
		return Stream.of(Portee.values()).toArray(String[]::new) ;
	}
	
	

	public String getName() {
		return name;
	}
}