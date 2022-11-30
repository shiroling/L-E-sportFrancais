package SAE_Esporter.src;

public enum Mois {
	JANVIER("Janvier"), FEVRIER("Février"), MARS("Mars"), AVRIL("Avril"), MAI("Mai"), JUIN("Juin"), JUILLET("Juillet"), AOUT("Août"), SEPTMBRE("Septembre"), OCTOBRE("Octobre"), NOVEMBRE("Novembre"), DECEMBRE("Décembre");
	
	private String denomination;

	private Mois(String denomination) {
		this.denomination = denomination;
	} 
	
	public String getDenomination() {
		return this.denomination;
	}
	
	public static String[] toStrings() {
		String[] mois = new String[12];
		int i = 0;
		for(Mois m : Mois.values()) {
			mois[i] = m.denomination;
			i++;
		}
		return mois;
	}
}
