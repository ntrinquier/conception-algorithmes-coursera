import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Exploration {
	public final char[][] grille;
	public final int dim;
	public final Dictionnaire d;
	public boolean[][] masque;
	public LinkedList<Character> prefix;
	public LinkedList<String> motsTrouves;
	
	public Exploration(char[][] grille, int dim, Dictionnaire d) {
		this.grille = grille;
		this.dim = dim;
		this.d = d;
	}
	
	public void explore1(Position p, Noeud n) {
		char c = grille[p.x][p.y];
		Noeud fils = n.trouveFils(c);
		if (fils != null) {
			prefix.addLast(c);
			masque[p.x][p.y] = true;

			if (fils.estMot()) {
				motsTrouves.add(Exploration.versChaine(prefix));
			}
		}
		prefix.removeLast();
		masque[p.x][p.y] = false;
	}
	
	public void explore(Position p, Noeud n) {
		char c = grille[p.x][p.y];
		Noeud fils = n.trouveFils(c);
		if (fils != null) {
			prefix.addLast(c);
			masque[p.x][p.y] = true;

			if (fils.estMot()) {
				motsTrouves.add(Exploration.versChaine(prefix));
			}
			
			for (Position nouvellePosition : p.deplacementsLegaux()) {
				explore(nouvellePosition, fils);
			}
			
			prefix.removeLast();
			masque[p.x][p.y] = false;
		}
	}
	
	public LinkedList<String> exploreTout() {
		masque = new boolean[dim][dim];
		prefix = new LinkedList<Character>();
		motsTrouves = new LinkedList<String>();
		
		for (int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				// explore1(new Position(this, i, j), d.racine);
				explore(new Position(this, i, j), d.racine);
			}
		}
		Collections.sort(motsTrouves, new OrdreNaturel());
		return motsTrouves;
	}
	
	public static String versChaine(LinkedList<Character> l) {
		StringBuilder sb = new StringBuilder();
		for (Character c: l)
			sb.append(c);
		return sb.toString();
	}
}

class Position {
	public final int x;
	public final int y;
	private final Exploration e;
	
	public Position(Exploration e, int x, int y) {
		this.e = e;
		this.x = x;
		this.y = y;
	}

	private boolean estLegal() {
		return (x >= 0) && (x < e.dim)
				&& (y >= 0) && (y < e.dim)
				&& e.masque[x][y] == false;
	}
	
	public List<Position> deplacementsLegaux() {
		List<Position> ret = new ArrayList<Position>();
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				Position pos = new Position(e, x+i, y+j);
				if (pos.estLegal()) {
					ret.add(pos);
				}
			}
		}
		
		return ret;
	}
}

class OrdreNaturel implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {  
      if (o1.length() > o2.length()) {
         return 1;
      } else if (o1.length() < o2.length()) {
         return -1;
      }
      return o1.compareTo(o2);
    }
}
