package SAE_Esporter;


public enum Portee {
	LOCAL("Local"), 
	NATIONAL("National"),
	INTERNATIONAL("International");
	
	private final String name;

	Portee(String s) {
		name = s;
	}
	 
	public String getName() {
		return name;
	}
	 
}
