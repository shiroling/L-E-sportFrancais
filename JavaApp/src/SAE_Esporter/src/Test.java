package SAE_Esporter.src;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Ecurie e = new Ecurie(1);
		System.out.println(e.toString());
		
		String[] ecuries = Ecurie.getToutesLesEcuries();
		for(int i = 0; i < ecuries.length; i++) {
			System.out.println( i + " : " + ecuries[i]);
		}
	}

}
