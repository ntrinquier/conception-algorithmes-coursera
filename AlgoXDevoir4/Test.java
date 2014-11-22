import java.io.*;
import java.util.*;

public class Test {

	public static Dictionnaire dico;

	public static void initDico() {
		dico = new Dictionnaire();

		try {
			BufferedReader br = new BufferedReader(new FileReader("dico.txt"));
			String mot;
			while ((mot = br.readLine()) != null) {
				dico.ajouteMot(mot);
			}
			br.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Impossible de trouver le fichier dico.txt dans le dossier courant " +
					System.getProperty("user.dir") +"\n" +
					"Vérifiez le dossier depuis lequel vous lancez votre programme java");
			System.exit(1);
		}
		catch (IOException e) {
			System.out.println("Erreur d'entrées / sorties:\n" + e);
			System.exit(1);
		}

	}

	public static void test5() {
		/*
    Noeud a1 = new Noeud('*');
    Noeud a2 = new Noeud('*');
    Noeud a3 = new Noeud('*');
    Noeud b = new Noeud('l');
    Noeud c = new Noeud('e');
    Noeud d = new Noeud('a');
    Noeud e = new Noeud('s');
    b.ajouteFils(c);
    b.ajouteFils(d);
    c.ajouteFils(e);
    c.ajouteFils(a1);
    d.ajouteFils(a2);
    e.ajouteFils(a3);

    System.out.printf("test5 %b %b %b end\n",
      b.trouveFils('e').trouveFils('s').estMot(),
      b.trouveFils('u') == null,
      b.trouveFils('a') == null
    );
		 */
	}

	public static void test6() {
	/*
    Exploration e = new Exploration(Data.t1, 2, dico);
    e.masque = new boolean[][] { { true, false }, { false, true } };
    Position p = new Position (e, 0, 0);
    System.out.printf("test6 ");
    for (Position pp: p.deplacementsLegaux()) {
      System.out.printf("(%d, %d) ", pp.x, pp.y);
    }
    System.out.printf("end\n");
	 */
	}

	public static void test7() {
		/*
		Exploration e = new Exploration(Data.t3, 2, dico);
		System.out.printf("test7 %s end\n", e.exploreTout());
		*/
	}

	public static void test8() {
		/*
		Exploration e = new Exploration(Data.t1, 2, dico);
		System.out.printf("test8 %s end\n", e.exploreTout());
		*/
	}

	public static void test9() {
		/*
		Exploration e = new Exploration(Data.t2, 4, dico);
		System.out.printf("test9 %s end\n", e.exploreTout());
		*/
	}

	public static void test10() {
		/*
		Exploration e = new Exploration(Data.t4, 9, dico);
		System.out.printf("test10 %s end\n", e.exploreTout());
		*/
	}

	public static void test11() {
		Exploration e = new Exploration(Data.t5, 12, dico);
		System.out.printf("test11 %s end\n", e.exploreTout());
	}

	public static void main(String[] args) {
		initDico();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();
	}

}

