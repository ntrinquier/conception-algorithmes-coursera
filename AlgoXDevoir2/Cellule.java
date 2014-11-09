
public class Cellule {
	private Objet o;
	private Cellule suivant;
	
	public Cellule(Objet o, Cellule suivant) {
		this.o = o;
		this.suivant = suivant;
	}

	public Objet getO() {
		return o;
	}

	public Cellule getSuivant() {
		return suivant;
	}
}
