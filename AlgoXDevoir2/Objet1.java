
public class Objet1 extends Objet {
	private String nom;
	
	public Objet1(String nom) {
		this.nom = nom;
	}

	@Override
	int hash() {
		int ret = 0;
		int c = 1;
		
		for (int n = this.nom.length()-1; n >= 0; n--) {
			ret += this.nom.charAt(n)*c;
			c *= 31;
		}
		
		return ret;
	}

	@Override
	String nom() {
		return this.nom;
	}
}
