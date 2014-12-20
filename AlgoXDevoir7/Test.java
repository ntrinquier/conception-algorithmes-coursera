import java.util.LinkedList;
import java.util.Collection;
import java.util.Arrays;

public class Test {
	public static Ville[] villes;
	public static LinkedList<Integer>[] voisins;

	// pour charger les cartes
	static Carte carte;
	//static final String chemin ="./"; // data file location
	static final String chemin ="./"; // data file location
	Carte ens = new Carte(chemin+"mf.txt");

	// variables qui serviront au test
	public static int v1, v2, v3, v4, v5;

	static void construitGraphe(Collection<Ville> cv, double minDist) {
		int n = cv.size(), k;
		double R = 6371000;
		double latDist = minDist * 180.0 / Math.PI / R;
		Ville v, w;

		Test.villes = new Ville[n];
		Test.voisins = new LinkedList[n];

		k = 0;
		for (Ville ville : cv) {
			Test.villes[k] = ville;
			Test.voisins[k++] = new LinkedList<Integer>();
		}

		Arrays.sort(Test.villes);

		for (int i = 0; i < n; i++) {
			v = Test.villes[i];
			for (int j = i+1; j < n; j++) {
				w = Test.villes[j];
				if (w.getLatitude()-v.getLatitude() > latDist) {
					break;
				}
				if (v.distance(w) <= minDist) {
					Test.voisins[i].add(j);
					Test.voisins[j].add(i);
				}
			}
		}
	}

	public static int compteCC(Ville[] villes, LinkedList<Integer>[] voisins) {
		boolean[] visited = new boolean[villes.length];
		int nbCC = 0;

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(voisins, visited, i);
				nbCC++;
			}
		}

		return nbCC;
	}

	private static void dfs(LinkedList<Integer>[] voisins, boolean[] visited, int i) {
		visited[i] = true;
		for (Integer j : voisins[i]) {
			if (!visited[j]) {
				dfs(voisins, visited, j);
			}
		}
	}

	public static boolean relie(Ville[] villes, LinkedList<Integer>[] voisins, int v1, int v2) {
		boolean[] added = new boolean[villes.length];
		LinkedList<Integer> toExplore = new LinkedList<Integer>();
		toExplore.addLast(v1);
		added[v1] = true;
		while (!toExplore.isEmpty()) {
			int i = toExplore.poll();
			for (Integer j : voisins[i]) {
				if (j == v2) {
					return true;
				}
				if (!added[j]) {
					toExplore.addLast(j);
					added[j] = true;
				}
			}
		}
		return false;
	}

	// trouve l'indice de la premiere ville nommee
	static int premiereVille(String s) {
		for (int i = 0; i<villes.length; i++)
			if (s.equals(villes[i].getNom())) return (i);
		return(-1);
	}

	public static void initMayotte(double minDist){
		Carte ens = new Carte(chemin+"mf.txt");
		construitGraphe(ens.villes(), minDist);
	}

	public static void initFrance(double minDist){
		Carte ens = new Carte(chemin+"fr.txt");
		construitGraphe(ens.villes(), minDist);
	}

	// cette fonction teste vos fonctions sur Mayotte
	public static void test1(double minDist) {
		System.out.println("Mayotte, pas de "+(int)minDist);
		initMayotte(minDist);

		v1 = premiereVille("Accua") ;
		v2 = premiereVille("Moutsamoudou");
		v3 = premiereVille("Bandraboua");
		v4 = premiereVille("Mambutzou");


		System.out.println("nb composantes : "+compteCC(villes, voisins));
		System.out.println(relie(villes, voisins, v1, v2));
		System.out.println(relie(villes, voisins, v1, v3));
		System.out.println(relie(villes, voisins, v2, v3));
		System.out.println(relie(villes, voisins, v2, v4));
	}


	// cette fonction teste vos fonctions sur la France
	// construitGraphe peut prendre du temps s'il n'est pas optimise
	// par ailleurs, on doit sans doute augmenter la taille de la pile

	public static void test2(double minDist) {

		System.out.println("France, pas de "+minDist);
		initFrance(minDist);
		System.out.println("composantes : "+compteCC(villes, voisins));

		v1 = premiereVille("Paris") ;
		v2 = premiereVille("Rouen");
		v3 = premiereVille("Ajaccio");
		v4 = premiereVille("Narbonne");
		v5 = premiereVille("La Testa");
		System.out.println(relie(villes, voisins, v1, v2));
		System.out.println(relie(villes, voisins, v1, v3));
		System.out.println(relie(villes, voisins, v1, v4));
		System.out.println(relie(villes, voisins, v3, v5));
		System.out.println(relie(villes, voisins, v1, v5));
	}

	public static void main (String[] args) {
		test1(1850);
		test1(2000);
		test1(3000);
		test1(3400);
		test1(4000);

		// tests sur la carte de France
		// peuvent etre longs voire demander d'augmenter la taille de la pile
		test2(2000);
		test2(5000);
		test2(7000);
		test2(12000);
	}
}
