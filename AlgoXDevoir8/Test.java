import java.util.LinkedList;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.text.DecimalFormat;




public class Test {
	// pour charger les cartes
	static Carte carte;
	static final String chemin ="./"; // data file location
	Carte ens = new Carte(chemin+"mf.txt");

	static HashMap<Ville, HashSet<Ville>> voisins;
	static HashMap<String, HashSet<Ville>> nom;
	static Ville[] villes;

	static void construitGraphe(Collection<Ville> cv, double minDist) {
		int n = cv.size(), k = 0;
		double R = 6371000;
		double latDist = minDist * 180.0 / Math.PI / R;
		Ville v, w;

		Test.nom = new HashMap<String, HashSet<Ville>>();
		Test.voisins = new HashMap<Ville, HashSet<Ville>>();
		Test.villes = new Ville[n];

		for (Ville ville : cv) {
			String nom = ville.getNom();
			if (!Test.nom.containsKey(nom)) {
				Test.nom.put(nom, new HashSet<Ville>());
			}
			Test.nom.get(nom).add(ville);
			Test.voisins.put(ville, new HashSet<Ville>());
			Test.villes[k++] = ville;
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
					Test.voisins.get(v).add(w);
					Test.voisins.get(w).add(v);
				}
			}
		}
	}
	
	private static void dfs(LinkedList<Integer>[] voisins, boolean[] visited, int i) {
		visited[i] = true;
		for (Integer j : voisins[i]) {
			if (!visited[j]) {
				dfs(voisins, visited, j);
			}
		}
	}

	static Ville premiereVille(String s) {
		return(nom.get(s).iterator().next());
	}

	static double Dijkstra(Ville orig, Ville dest) {
		PriorityQueue<VilleDist> distances = new PriorityQueue<VilleDist>();
		HashMap<Ville, VilleDist> villeDist = new HashMap<Ville, VilleDist>();
		VilleDist vd;
		double di;

		for (Ville v : Test.villes) {
			vd = new VilleDist(v, Double.POSITIVE_INFINITY);
			villeDist.put(v, vd);
			distances.add(vd);
		}

		updateHeap(distances, villeDist.get(orig), 0);

		while (!distances.isEmpty()) {
			vd = distances.poll();
			if (vd.d == Double.POSITIVE_INFINITY) {
				return -1;
			}
			if (vd.v.equals(dest)) {
				return villeDist.get(dest).d;
			}

			for (Ville voisin : Test.voisins.get(vd.v)) {
				di = vd.d+vd.v.distance(voisin);
				if (di < villeDist.get(voisin).d) {
					updateHeap(distances, villeDist.get(voisin), di);
				}
			}
		}

		if (villeDist.get(dest).d == Double.POSITIVE_INFINITY) {
			return -1;
		} else {
			return villeDist.get(dest).d;
		}
	}

	private static void updateHeap(PriorityQueue<VilleDist> heap, VilleDist vd, double value) {
		heap.remove(vd);
		vd.d = value;
		heap.add(vd);
	}

	public static void initMayotte(double minDist) {
		Carte ens = new Carte(chemin+"mf.txt");
		construitGraphe(ens.villes(), minDist);
	}

	public static void initFrance(double minDist){
		Carte ens = new Carte(chemin+"fr.txt");
		construitGraphe(ens.villes(), minDist);
	}

	public static void test1(double minDist) {
		System.out.println();
		System.out.println("Mayotte, pas de "+minDist);
		initMayotte(minDist);

		Ville v1 = premiereVille("Accua") ;
		Ville v2 = premiereVille("Moutsamoudou");
		Ville v3 = premiereVille("Bandraboua");
		Ville v4 = premiereVille("Mambutzou");
		afficheDijkstra(v1, v2);
		afficheDijkstra(v2, v1);
		afficheDijkstra(v1, v3);
		afficheDijkstra(v3, v1);
		afficheDijkstra(v1, v4);
		afficheDijkstra(v4, v1);
		afficheDijkstra(v2, v3);
	}


	public static void afficheDijkstra(Ville v1, Ville v2) {
		DecimalFormat df = new DecimalFormat("#.000");
		double d = Dijkstra(v1,v2);
		String s = "  pas de chemin";
		if (d > 0) s = df.format(Dijkstra(v1,v2) / 1000);

		System.out.println(v1.getNom()+" "+v2.getNom()+" "+s);
	}


	public static void test2(double minDist) {
		System.out.println();
		System.out.println("France, pas de "+minDist);

		initFrance(minDist);

		Ville paris = premiereVille("Paris") ;
		Ville rouen = premiereVille("Rouen");
		Ville palaiseau = premiereVille("Palaiseau");
		Ville perpignan = premiereVille("Perpignan");
		Ville strasbourg = premiereVille("Strasbourg");
		Ville hagenau = premiereVille("Hagenau");
		Ville brest = premiereVille("Brest");
		Ville hendaye = premiereVille("Hendaye");

		afficheDijkstra(paris, rouen);
		afficheDijkstra(palaiseau, rouen);
		afficheDijkstra(palaiseau, paris);
		afficheDijkstra(paris, perpignan);
		afficheDijkstra(hendaye, perpignan);
		afficheDijkstra(paris, strasbourg);
		afficheDijkstra(hagenau, strasbourg);
		afficheDijkstra(hagenau, brest);
	}

	public static void main (String[] args) {
		test1(1850);
		test1(2000);
		test1(3000);
		test1(3400);
		test1(4000);

		//tests sur la carte de France
		test2(2000);
		test2(5000);
		test2(7000);
		test2(10000);
	}
}
