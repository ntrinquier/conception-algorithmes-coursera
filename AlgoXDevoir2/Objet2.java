
public class Objet2 extends Objet {
	private String nom;
	
	public Objet2(String nom) {
		this.nom = nom;
	}

	@Override
	int hash() {
		int ret = 5381;
		
		for (int n = 0; n < this.nom.length(); n++) {
			ret = ret*33^this.nom.charAt(n);
		}
		
		return ret;
	}

	@Override
	String nom() {
		return this.nom;
	}
}
