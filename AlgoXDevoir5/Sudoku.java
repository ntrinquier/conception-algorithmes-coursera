class Sudoku {
	int[][] grille;

	Sudoku(int[][] t) {
		this.grille = new int[t.length][t[0].length];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				this.grille[i][j] = t[i][j];
			}	
		}
	}

	public boolean verifieLigne(int i) {
		boolean[] ligne = new boolean[10];
		for (int j = 0; j < 10; j++) {
			ligne[j] = false;
		}
		for (int j = 0; j < 9; j++) {
			if (grille[i][j] != 0 && ligne[grille[i][j]] == true) {
				return false;
			}
			ligne[grille[i][j]] = true;
		}
		return true;
	}

	public boolean verifieColonne(int j) {
		boolean[] colonne = new boolean[10];
		for (int i = 0; i < 10; i++) {
			colonne[i] = false;
		}
		for (int i = 0; i < 9; i++) {
			if (grille[i][j] != 0 && colonne[grille[i][j]] == true) {
				return false;
			}
			colonne[grille[i][j]] = true;
		}
		return true;
	}

	public boolean verifieCarre(int i, int j) {
		boolean[] carre = new boolean[10];
		for (int k = 0; k < 10; k++) {
			carre[k] = false;
		}
		i = (i/3)*3;
		j = (j/3)*3;
		for (int k = 0; k < 9; k++) {
			int ci = i+k/3, cj = j+k%3;
			if (grille[ci][cj] != 0 && carre[grille[ci][cj]] == true) {
				return false;
			}
			carre[grille[ci][cj]] = true;
		}
		return true;
	}

	public boolean verifiePossible(int i, int j, int val) {
		if (this.grille[i][j] != 0) {
			return false;
		}
		this.grille[i][j] = val;
		if (!verifieLigne(i) || !verifieColonne(j) || !verifieCarre(i, j)) {
			this.grille[i][j] = 0;
			return false;
		}
		this.grille[i][j] = 0;
		return true;
	}

	public boolean resousGrille() {
		return resousGrille(0, 0);
	}

	public boolean resousGrille(int i, int j) {
		if (i == 9) {
			return true;
		}
		if (this.grille[i][j] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (verifiePossible(i, j, k)) {
					this.grille[i][j] = k;
					boolean possible;
					if (j == 8) {
						possible = resousGrille(i+1, 0);
					} else {
						possible = resousGrille(i, j+1);
					}
					if (possible) {
						return true;
					}
					this.grille[i][j] = 0;
				}
			}
			return false;
		} else {
			if (j == 8) {
				return resousGrille(i+1, 0);
			} else {
				return resousGrille(i, j+1);
			}
		}
	}

	public int solutionUnique() {
		return solutionUnique(0, 0);
	}
	
	public int solutionUnique(int i, int j) {
		if (i == 9) {
			return 1;
		}
		int nbSol = 0, possible, k;
		if (this.grille[i][j] == 0) {
			for (k = 1; k <= 9; k++) {
				if (verifiePossible(i, j, k)) {
					this.grille[i][j] = k;
					if (j == 8) {
						possible = solutionUnique(i+1, 0);
					} else {
						possible = solutionUnique(i, j+1);
					}
					if (possible > 0) {
						nbSol += possible;
						if (nbSol >= 2) {
							return 2;
						}
					}
					this.grille[i][j] = 0;
				}
			}
			return nbSol;
		} else {
			if (j == 8) {
				return solutionUnique(i+1, 0);
			} else {
				return solutionUnique(i, j+1);
			}
		}
	}

	public void afficheGrille() {
		if (this.grille == null)
			return;

		for(int i = 0 ;i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(this.grille[i][j]+" ");
			}
			System.out.println();
		}
	}
}
