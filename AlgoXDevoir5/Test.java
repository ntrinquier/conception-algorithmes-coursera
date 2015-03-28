public class Test {

  public static void main(String[] args) {
    // test1();
    // test2();
    // test3();
    // test4();
    // test5();
    test6();
  }

  public static void test1() {
    // Une fonction de test très simple pour vous aider à débugger votre code.
    double xtab[] = new double[] {  0, 1 };
    double ytab[] = new double[] { -1, 1 };
    double[] ret = Seg.erreur(xtab, ytab, 0, 1);
    System.out.printf("test1 a=%.2f, b=%.2f, e=%.2f\n", ret[0], ret[1], ret[2]);
  }

  public static void test2() {
    // Une fonction de test très simple pour vous aider à débugger votre code.
    double xtab[] = new double[] {  0, 1,  2 };
    double ytab[] = new double[] { -1, 1, -1 };
    double[] ret = Seg.erreur(xtab, ytab, 0, 2);
    System.out.printf("test2 a=%.2f, b=%.2f, e=%.2f\n", ret[0], ret[1], ret[2]);
  }

  public static void test3() {
    double xtab[] = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    double ytab[] = new double[] { 7.153, 12.555, 25.835, 40.771, 42.252, 54.797, 67.178, 76.227, 83.967, 92.970, 106.734 };
    double[] ret = Seg.erreur(xtab, ytab, 0, 2);
    System.out.printf("test3 a=%.2f, b=%.2f, e=%.2f\n", ret[0], ret[1], ret[2]);
  }

  public static void test4() {
    // Une fonction de test très simple pour vous aider à débugger votre code.
    double xtab[] = new double[] {  0, 1 };
    double ytab[] = new double[] { -1, 1 };
    System.out.printf("test4 n=%d\n", Seg.nbSeg(xtab, ytab, 200));
  }

  public static void test5() {
    // Une fonction de test très simple pour vous aider à débugger votre code.
    double xtab[] = new double[] {  0, 1,  2, 3 };
    double ytab[] = new double[] { -1, 1, -1, 1 };
    double[] ret = Seg.erreur(xtab, ytab, 0, 3);
    System.out.printf("test5-0 a=%.2f, b=%.2f, e=%.2f\n", ret[0], ret[1], ret[2]);
    System.out.printf("test5-1 n=%d\n", Seg.nbSeg(xtab, ytab, 3));
    System.out.printf("test5-2 n=%d\n", Seg.nbSeg(xtab, ytab, 4));
  }

  public static void test6() {
    final int n = 1000;
    double xtab [] = new double[n];
    double ytab [] = new double[n];
    for (int k=0; k<16; k++) {
      TestHelpers.iterate(xtab, ytab);
      System.out.printf("test6-%d n=%d\n" , k, Seg.nbSeg(xtab, ytab, 200));
    }
  }

}

// Classe permettant de générer des tableaux de test aléatoires. Ne pas toucher !
class TestHelpers {
    static int compteur = 0;

  static double newB (double a, double na, double b, double x) {
    return (a * x + b - na * x) ;
  }

  static void generate (int n, int c, double a, double b, double x, double[] xtab, double[] ytab) {
    for (int i = 0; i < n; i++) {
      x = x + Prng.next() * 20;
      xtab[c] = x;
      ytab[c] = x * a + b + 9 * (Prng.next() - 0.5);
      c++;
    }
    return;
  }

    static boolean testSorted (double[] t) {
	for (int i = 0; i<t.length - 1; i++)
	    {if (t[i] >= t[i+1]) return(false); }
	return(true);
    }

  static void iterate (double[] xtab, double[] ytab) {
      double corr = 0;
      if(compteur==0) corr = -20;
      if(compteur==1) corr = -10;
      if(compteur==2) corr = 10;
      if(compteur==3) corr = -12;
      if(compteur==5) corr = -2;
      if(compteur==6) corr = -1.5;
      if(compteur==7) corr = -15;
      if(compteur==10) corr = -6.2;
      if(compteur==8)
	  { Prng.next();
	      Prng.next();
	      Prng.next();
	      Prng.next();
	      Prng.next();
	      Prng.next();
	      corr = 7.4; }
	for (int i = 0; i<2; i++) {Prng.next(); }
    int c = 0;
    int n = 0;
    double a = 1;
    double na;
    int ns = 0;
    double b = 0;
    double cc = 0;
    xtab[0] = 0;
    ytab[0] = 0;
    while (c < xtab.length -1) {
      do {
        na = (Prng.next() - 0.5) * 12;
         } 
      while (Math.abs(a-na) < 2) ;
      ns ++;
      b = newB(a, na, b, xtab[c]);
      a = na;

      n =  (int)(Prng.next() * (40.0 + corr))+16 ;
      
      if (n+c >= xtab.length - 30)     n = xtab.length -c ;

      if (c !=0) {cc = xtab[c-1]; }
      generate (n, c, a, b, cc, xtab, ytab);
      c = c + n;
      }
    compteur ++;
  }

    // fait un test sur un tableau de taille 1000
    // actuellement ça affiche pas mal de trucs que j'avais utilisé pour débugger
    public static void main(String[] args) {
	double x;
	// for (int k=0; k<10000; k++) { x = Prng.next();
	//    if (x<0) 	System.out.println(Prng.next()); }

	 final int n = 1000;
	double xtab [] = new double[n];
	double ytab [] = new double[n];
	iterate(xtab, ytab);
		for (int i = 20; i< 28; i++) {
	  System.out.println("i="+i+" x="+xtab[i]);
	 }
	iterate(xtab, ytab);
	// double err [] = new double[n+1];
	// int[] pr = new int[n+1];
	for (int k=0; k<1; k++) {
	    iterate(xtab, ytab);
	    System.out.println("nb segments: " + +Seg.nbSeg(xtab,ytab,200));
	    // int i = n-1;
	    // while (i>0){
	    //     System.out.print(i+":"+pr[i]+"   ");
	    //    i = pr[i];
	}
    }

}


class Prng {
  static double seed = 0.4435431;
  static int m = 1;
  static double a = 68.45633;
  static double b = 0.724514 ;

  static double next() {
    seed = (double) (((seed) * a + b) % m);
    return seed;
  }
}
