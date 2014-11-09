import java.util.NoSuchElementException;

public class Liste {
	private int l;
	private Cellule tete;
	
	public Liste() {
		this.l = 0;
		this.tete = null;
	}

	public int longueur() {
		return this.l;
	}

	public boolean contient(Objet o) {
		Cellule it = this.tete;
		
		while (it != null) {
			if (it.getO().equals(o)) {
				return true;
			}
			
			it = it.getSuivant();
		}
		
		return false;
	}

	public Liste ajouteTete(Objet o) {
		this.tete = new Cellule(o, this.tete);
		this.l++;
		
		return this;
	}

	public Liste supprimeTete() {
		if (this.l == 0) {
			throw new NoSuchElementException("liste vide");
		}
		
		this.tete = this.tete.getSuivant();
		this.l--;
		
		return this;
	}

}
