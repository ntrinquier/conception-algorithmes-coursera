class Seg {

	// Cette fonction effectue une régression linéaire sur les points allant des
	// indices "d" (début) �  "f" (fin). Elle calcule les coefficients "a" et "b"
	// et renvoie également la somme des carrés des erreurs.
	static double[] erreur (double[] xtab, double[] ytab, int d, int f) {
		if (xtab.length != ytab.length || d < 0 || f < 0 || d >= xtab.length || f >= xtab.length || f < d) {
			throw new IllegalArgumentException();
		}
		int n = f-d+1;
		if (n == 1) {
			return new double[] {Double.NaN, Double.NaN, 0};
		}
		double a = 0;
		double b = 0;
		double err = 0;
		double sommeX = 0;
		double sommeY = 0;
		double sommeXCarre = 0;
		double sommeDoubleProduit = 0;

		for (int i = d; i <= f; i++) {
			sommeX += xtab[i];
			sommeXCarre += xtab[i]*xtab[i];
			sommeY += ytab[i];
			sommeDoubleProduit += xtab[i]*ytab[i];
		}

		a = (n*sommeDoubleProduit-sommeX*sommeY)/(n*sommeXCarre-sommeX*sommeX);
		b = (sommeY-a*sommeX)/n;

		for (int i = d; i <= f; i++) {
			double tmp = (ytab[i]-a*xtab[i]-b);
			err += tmp*tmp;
		}

		return(new double[] {a, b, err});

	}

	// Meilleur facon de decouper de 0 a n
	static double meilleurCout(double[][] errors, double[] meilleurCouts, int[] path, double c, int n) {
		if (n < 0) {
			return 0;
		}
		if (meilleurCouts[n] != Double.POSITIVE_INFINITY) {
			return meilleurCouts[n];
		}
		double coutMin = Double.POSITIVE_INFINITY;
		double cout;
		int iMin = 0;
		for (int i = 0; i <= n-1; i++) {
			cout = errors[i][n]+c+meilleurCout(errors, meilleurCouts, path, c, i-1);
			if (cout < coutMin) {
				coutMin = cout;
				iMin = i;
			}
		}
		path[n] = iMin;
		meilleurCouts[n] = coutMin;
		return coutMin;
	}

	// Cette fonction calcule le nombre de segments pour un cout donne c.
	static int nbSeg (double[] xtab, double[] ytab, double c) {
		int k = 0;
		double[][] errors = new double[xtab.length][xtab.length];
		double[] meilleurCouts = new double[xtab.length];
		int[] path = new int[xtab.length];
		for (int i = 0; i < xtab.length-1; i++) {
			meilleurCouts[i] = Double.POSITIVE_INFINITY;
			for (int j = i+1; j < xtab.length; j++) {
				errors[i][j] = erreur(xtab, ytab, i, j)[2];
			}
		}
		meilleurCouts[xtab.length-1] = Double.POSITIVE_INFINITY;
		meilleurCout(errors, meilleurCouts, path, c, xtab.length-1);
		for (int i = xtab.length; i != 0; i = path[i-1]) {
			k++;
		}
		return k;
	}
}