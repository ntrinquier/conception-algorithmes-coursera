
public class TableDeHachage {
	private Liste[] listes;
	
	public TableDeHachage(int i) {
		this.listes = new Liste[i];
		
		for (int j = 0; j < i; j++) {
			this.listes[j] = new Liste();
		}
	}

	public void ajoute(Objet o) {
		int m = o.hash() % this.listes.length;
		
		if (m < 0) {
			m += this.listes.length;
		}
		
		this.listes[m].ajouteTete(o);
	}

	public boolean contient(Objet o) {
		int m = o.hash() % this.listes.length;
		
		if (m < 0) {
			m += this.listes.length;
		}
		
		return this.listes[m].contient(o);
	}

	public int[] remplissageMax() {
		int index = 0;
		int longueur = this.listes[index].longueur();
		
		for (int j = 1; j < this.listes.length; j++) {
			if (longueur < this.listes[j].longueur()) {
				index = j;
				longueur = this.listes[j].longueur();
			}
		}
		
		int[] ret = {index, longueur};
		return ret;
	}
}
