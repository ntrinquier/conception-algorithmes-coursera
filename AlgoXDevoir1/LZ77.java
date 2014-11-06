// Ces squelettes sont à compléter et sont là uniquement pour prévenir des
// erreurs de compilation.
class Element {
	public Occurrence occ;
	public int c;
	Element (Occurrence e, int s) {
		this.occ = e;
		this.c = s;
	}
}

class Occurrence {
	public int retour;
	public int taille;
	
	Occurrence (int retour, int taille) {
		this.retour = retour;
		this.taille = taille;
	}
}

public class LZ77 {
	public static Occurrence plusLongueOccurrence(int[] t, int positionCourante, int tailleFenetre) {
		if (t == null) {
			throw new IllegalArgumentException("t is null");
		} else if (t.length == 0) {
			return new Occurrence(0, 0);
		}
		
		int re = 0;
		int ta = 0;
		
		// taille de la fen�tre � gauche en prenant en compte la limitation du tableau
		// positionCourante n'est pas dans la fenetre
		int fenetreGauche = java.lang.Math.min(positionCourante, tailleFenetre);
		
		// passage en revue de toutes les occurrences
		for (int retour = 1; retour < fenetreGauche+1; retour++) {
			for (int taille = 1; taille < java.lang.Math.min(retour, t.length-positionCourante)+1; taille++) {
				boolean isOccurrence = true;
				for (int i = 0; i < taille; i++) {
					if (t[positionCourante-retour+i] != t[positionCourante+i]) {
						isOccurrence = false;
						break;
					}
				}
				if (isOccurrence && taille >= ta) {
					re = retour;
					ta = taille;
				}
			}
		}
		return new Occurrence(re, ta);
	}
	
	public static int LZ77Longueur(int[] t, int tailleFenetre) {
		if (t == null) {
			throw new IllegalArgumentException("t is null");
		} else if (t.length == 0) {
			return 0;
		}
		
		int ret = 0;
		int i = 0;
		
		while (i < t.length) {
			Occurrence o = plusLongueOccurrence(t, i, tailleFenetre);
			i += o.taille+1;
			ret++;
		}
		
		return ret;
	}
	
	public static Element[] LZ77(int[] tab, int tailleFenetre) {
		if (tab == null) {
			throw new IllegalArgumentException("tab is null");
		} else if (tab.length == 0) {
			return new Element[0];
		}
		
		Element[] ret = new Element[LZ77.LZ77Longueur(tab, tailleFenetre)];
		int i = 0;
		int j = 0;
		
		while (i < tab.length) {
			Occurrence o = plusLongueOccurrence(tab, i, tailleFenetre);
			ret[j] = new Element(o, tab[i+o.taille]);
			i += o.taille+1;
			j++;
		}
		
		return ret;
	}
	
	public static int LZ77InverseLongueur(Element[] t) {
		if (t == null) {
			throw new IllegalArgumentException("t is null");
		}
		
		int ret = 0;
		
		for (Element e : t) {
			ret += e.occ.taille+1;
		}
		
		return ret;
	}
	
	public static int[] LZ77Inverse(Element[] t) {
		if (t == null) {
			throw new IllegalArgumentException("t is null");
		} else if (t.length == 0) {
			return new int[0];
		}
		
		int[] ret = new int[LZ77.LZ77InverseLongueur(t)];
		int k = 0;
		
		for (Element e : t) {
			if (e.occ.taille== 0) {
				ret[k] = e.c;
				k++;
			} else {
				LZ77.blit(ret, ret, k-e.occ.retour, e.occ.taille, k);
				ret[k+e.occ.taille] = e.c;
				k += e.occ.taille+1;
			}
		}
		
		return ret;
	}
	
	public static void blit(int[] t1, int[] t2, int start1, int len, int start2) {
		if (t1 == null) {
			throw new IllegalArgumentException("t1 is null");
		} else if (t2 == null) {
				throw new IllegalArgumentException("t2 is null");
		}
		
		for (int i = 0; i < len; i++)
			t2[start2+i] = t1[start1+i];
	}
	
	public static void afficheEncode(Element[] tab) {
		if (tab == null) {
			throw new IllegalArgumentException("tab is null");
		} else if (tab.length == 0) {
			System.out.print("\n");
		}
		
		for (int i = 0; i < tab.length-1; i++)
			System.out.print("("+tab[i].occ.retour+","+tab[i].occ.taille+")"+tab[i].c);
		System.out.print("("+tab[tab.length-1].occ.retour+","+tab[tab.length-1].occ.taille+")"+tab[tab.length-1].c+"\n");
	}
	
	public static void afficheDecode(int[] t) {
		if (t == null) {
			throw new IllegalArgumentException("t is null");
		} else if (t.length == 0) {
			System.out.print("\n");
		}
		
		for (int i = 0; i < t.length-1; i++)
			System.out.print(t[i]+" ");
		System.out.print(t[t.length-1]+"\n");
	}
}