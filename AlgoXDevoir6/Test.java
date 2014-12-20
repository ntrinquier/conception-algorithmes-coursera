class Test {

  // Cette fonction résout la grille donnée dans le sujet. Vous pourrez la
  // lancer par curiosité, une fois le sujet terminé, elle ne donne pas de
  // points.
  public static void test() {
    int[][] tab2 = {{0,0,1,0,0,0,0,0,0},{0,3,0,0,0,0,0,0,0},
          {7,0,0,0,4,0,0,0,0},{0,0,0,0,0,0,0,0,0},
          {0,0,0,0,0,0,0,0,5},{0,0,0,0,0,0,0,0,0},
          {0,0,0,0,0,0,0,0,0},{0,0,2,0,0,0,0,0,0},
          {0,0,0,0,0,0,7,0,0}};
    int[][] tab = {{9,0,3,0,0,0,0,0,8},{0,6,0,0,0,0,0,1,0},
          {0,5,0,2,0,0,0,9,0},{0,0,0,1,6,4,5,0,2},
          {0,0,0,0,3,0,0,0,0},{6,0,1,5,8,7,0,0,0},
          {0,4,0,0,0,6,0,8,0},{0,8,0,0,0,0,0,2,0},
          {2,0,0,0,0,0,3,0,7}};
    Sudoku s = new Sudoku(tab2);
    System.out.println(s.resousGrille());
    System.out.println();
    System.out.println(s.solutionUnique());
    s.afficheGrille();
  }

  // Premier test : votre fonction "verifieLigne"
  public static void test1() {
    System.out.println("test1");
    int[][] tab = {{0,0,1,0,0,0,0,0,0},{0,3,0,0,0,0,0,0,0},
          {7,0,0,0,4,0,0,7,0},{0,0,0,0,0,0,0,0,0},
          {0,0,0,0,0,0,0,0,5},{0,0,0,0,0,0,0,0,0},
          {0,0,0,0,0,0,0,0,0},{0,0,2,0,0,2,0,0,0},
          {0,0,0,0,0,0,7,0,0}};
    Sudoku s = new Sudoku(tab);
    for (int i = 0; i < 9; i++) {
      System.out.println(s.verifieLigne(i));
    }
    System.out.println("end");
  }

  // Deuxième test : votre fonction "verifieColonne"
  public static void test2() {
    System.out.println("test2");
    int[][] tab = {{9,0,3,0,0,0,0,0,8},{0,6,0,0,0,0,0,1,0},
          {0,5,0,2,0,0,0,9,0},{0,0,0,1,6,4,5,0,2},
          {0,0,0,0,3,0,0,0,0},{6,0,1,5,8,7,0,0,0},
          {9,4,0,0,0,6,0,8,2},{0,8,0,0,0,0,0,2,0},
          {2,0,0,0,0,0,3,0,7}};
    Sudoku s = new Sudoku(tab);
    for (int i = 0; i < 9; i++) {
      System.out.println(s.verifieColonne(i));
    }
    System.out.println("end");
  }

  // Troisième test : votre fonction "verifieCarre"
  public static void test3() {
    System.out.println("test3");
     int[][] tab = {{9,0,3,0,0,0,0,0,8},{0,6,0,0,0,0,8,1,0},
          {0,5,9,2,0,0,0,9,0},{0,0,0,1,6,4,5,0,2},
          {0,0,0,0,3,0,0,0,0},{6,0,1,5,8,7,0,0,0},
          {0,4,0,0,0,6,2,8,0},{0,8,0,0,0,0,0,2,0},
          {2,0,0,0,0,0,3,0,7}};
    Sudoku s = new Sudoku(tab);
    for (int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        System.out.println(s.verifieCarre(i,j));
      }
    }
    System.out.println("end");
  }
  
  // Peut-on remplir la case (i, j) avec la valeur k ?
  public static void test4() {
    System.out.println("test4");
     int[][] tab = {{9,0,3,0,0,0,0,0,8},{0,6,0,0,0,0,0,1,0},
          {0,5,0,2,0,0,0,9,0},{0,0,0,1,6,4,5,0,2},
          {0,0,0,0,3,0,0,0,0},{6,0,1,5,8,7,0,0,0},
          {0,4,0,0,0,6,0,8,0},{0,8,0,0,0,0,0,2,0},
          {2,0,0,0,0,0,3,0,7}};
    Sudoku s = new Sudoku(tab);
    for (int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        for(int k = 1; k <= 9; k++) {
          System.out.print(s.verifiePossible(i,j,k)+",");
        }
      }
    }
    System.out.println("end");
  }

  // Résolution complète de quelques grilles.
  public static void test5() {
    System.out.println("test5");

    int[][] t = {{2 ,1 ,3 ,4 ,5 ,6 ,7 ,0 ,0 },{0 ,0 ,6 ,0 ,0 ,9 ,1 ,0 ,3 },{9 ,8 ,7 ,1 ,0 ,3 ,0 ,5 ,0 },{1 ,0 ,4 ,3 ,7 ,0 ,0 ,8 ,9 },{3 ,0 ,8 ,0 ,9 ,0 ,0 ,0 ,0 },{0 ,9 ,5 ,6 ,4 ,0 ,0 ,3 ,1 },{5 ,0 ,9 ,0 ,1 ,0 ,0 ,0 ,2 },{8 ,3 ,1 ,5 ,6 ,2 ,9 ,7 ,0 },{6 ,7 ,2 ,9 ,3 ,0 ,0 ,0 ,5 }};
    Sudoku s = new Sudoku(t);
    s.resousGrille();
    s.afficheGrille();
    System.out.println();

    int[][] t2 = {{0 ,0 ,3 ,0 ,0 ,7 ,0 ,4 ,9 },{6 ,0 ,8 ,1 ,9 ,4 ,0 ,0 ,0 },{4 ,0 ,5 ,2 ,0 ,0 ,0 ,6 ,7 },{2 ,1 ,0 ,3 ,5 ,6 ,0 ,0 ,0 },{3 ,0 ,7 ,0 ,0 ,9 ,6 ,0 ,2 },{9 ,0 ,6 ,0 ,1 ,0 ,3 ,0 ,4 },{0 ,4 ,0 ,8 ,2 ,0 ,9 ,0 ,6 },{0 ,6 ,2 ,0 ,4 ,0 ,5 ,0 ,3 },{0 ,0 ,0 ,0 ,7 ,0 ,4 ,0 ,1 }};
    Sudoku s2 = new Sudoku(t2);
    s2.resousGrille();
    s2.afficheGrille();
    System.out.println();

    int[][] t3 = {{1 ,0 ,0 ,0 ,0 ,0 ,0 ,9 ,5 },{0 ,0 ,6 ,1 ,0 ,8 ,0 ,0 ,7 },{0 ,8 ,9 ,0 ,0 ,0 ,4 ,0 ,6 },{4 ,0 ,1 ,5 ,0 ,0 ,0 ,0 ,9 },{0 ,0 ,7 ,0 ,1 ,0 ,3 ,6 ,4 },{0 ,9 ,8 ,3 ,0 ,4 ,0 ,0 ,1 },{0 ,1 ,0 ,6 ,5 ,2 ,9 ,7 ,0 },{3 ,7 ,5 ,0 ,8 ,1 ,6 ,0 ,0 },{0 ,6 ,2 ,7 ,4 ,0 ,1 ,5 ,0 }};        
    Sudoku s3 = new Sudoku(t3);
    s3.resousGrille();
    s3.afficheGrille();
    System.out.println();

    int[][] t4 = {{0 ,3 ,4 ,0 ,5 ,0 ,6 ,8 ,7 },{5 ,6 ,7 ,4 ,2 ,0 ,9 ,1 ,3 },{1 ,8 ,0 ,3 ,6 ,7 ,0 ,4 ,5 },{3 ,0 ,0 ,5 ,0 ,0 ,0 ,7 ,9 },{0 ,5 ,8 ,0 ,0 ,2 ,1 ,3 ,6 },{7 ,0 ,6 ,8 ,1 ,3 ,0 ,5 ,0 },{6 ,0 ,0 ,2 ,8 ,1 ,0 ,0 ,0 },{8 ,2 ,5 ,9 ,3 ,4 ,7 ,6 ,1 },{9 ,4 ,1 ,0 ,7 ,0 ,0 ,2 ,8 }};        
    Sudoku s4 = new Sudoku(t4);
    s4.resousGrille();
    s4.afficheGrille();
    System.out.println();

    int[][] t5 = {{1 ,2 ,0 ,5 ,4 ,7 ,0 ,8 ,9 },{5 ,4 ,7 ,8 ,9 ,6 ,1 ,3 ,2 },{6 ,0 ,0 ,1 ,0 ,0 ,0 ,5 ,0 },{2 ,1 ,0 ,3 ,0 ,0 ,7 ,0 ,4 },{0 ,6 ,4 ,0 ,0 ,9 ,0 ,1 ,8 },{7 ,0 ,8 ,2 ,0 ,4 ,3 ,0 ,5 },{8 ,3 ,0 ,0 ,7 ,5 ,0 ,4 ,0 },{0 ,7 ,6 ,9 ,8 ,0 ,5 ,2 ,0 },{9 ,5 ,1 ,4 ,3 ,2 ,8 ,7 ,6 }};        
    Sudoku s5 = new Sudoku(t5);
    s5.resousGrille();
    s5.afficheGrille();

    System.out.println("end");
  }
  
  // Solutions uniques, ou pas ?
  public static void test6() {
    System.out.println("test6");
    int[][] t = {{2 ,3 ,0 ,0 ,5 ,6 ,0 ,0 ,0 },{0 ,7 ,8 ,4 ,3 ,0 ,1 ,0 ,6 },{0 ,9 ,1 ,2 ,0 ,7 ,0 ,4 ,0 },{0 ,2 ,3 ,0 ,7 ,0 ,6 ,0 ,8 },{4 ,0 ,6 ,3 ,9 ,8 ,2 ,0 ,7 },{0 ,8 ,0 ,6 ,1 ,0 ,0 ,0 ,0 },{3 ,1 ,2 ,0 ,0 ,5 ,9 ,0 ,4 },{0 ,0 ,0 ,0 ,0 ,0 ,5 ,6 ,1 },{9 ,6 ,0 ,0 ,0 ,0 ,8 ,0 ,2 }};
    Sudoku s = new Sudoku(t);
    System.out.println(s.solutionUnique());

    int[][] t2 = {{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,6 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,0 ,0 ,0 ,6 ,0 },{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,3 },{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,0 ,3 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,7 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 }};
    Sudoku s2 = new Sudoku(t2);
    System.out.println(s2.solutionUnique());
    
    int[][] t3 = {{0 ,0 ,0 ,0 ,0 ,9 ,7 ,0 ,5 },{4 ,0 ,0 ,1 ,0 ,0 ,0 ,9 ,0 },{0 ,7 ,8 ,2 ,3 ,5 ,0 ,4 ,6 },{2 ,0 ,0 ,7 ,4 ,0 ,0 ,0 ,0 },{7 ,0 ,5 ,0 ,0 ,0 ,3 ,6 ,0 },{6 ,0 ,0 ,0 ,5 ,0 ,0 ,1 ,0 },{0 ,0 ,1 ,5 ,0 ,0 ,9 ,0 ,0 },{0 ,2 ,4 ,0 ,8 ,7 ,6 ,0 ,0 },{8 ,9 ,0 ,0 ,1 ,3 ,0 ,2 ,0 }};
    Sudoku s3 = new Sudoku(t3);
    System.out.println(s3.solutionUnique());

    
    int[][] t4 = {{1 ,0 ,3 ,0 ,4 ,0 ,7 ,0 ,0 },{0 ,0 ,0 ,1 ,9 ,7 ,2 ,8 ,0 },{7 ,8 ,9 ,0 ,3 ,6 ,0 ,0 ,0 },{2 ,0 ,0 ,4 ,7 ,0 ,0 ,9 ,0 },{0 ,6 ,0 ,9 ,1 ,2 ,0 ,0 ,7 },{9 ,7 ,0 ,0 ,6 ,5 ,3 ,1 ,0 },{0 ,3 ,0 ,7 ,5 ,0 ,6 ,0 ,0 },{4 ,5 ,0 ,6 ,0 ,1 ,9 ,0 ,0 },{0 ,9 ,0 ,0 ,8 ,4 ,5 ,7 ,1 }};
    Sudoku s4 = new Sudoku(t4);
    System.out.println(s4.solutionUnique());

    int[][] t5 = {{0 ,0 ,0 ,0 ,0 ,0 ,0 ,2 ,0 },{0 ,0 ,8 ,0 ,0 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },{0 ,0 ,2 ,0 ,0 ,0 ,7 ,0 ,0 },{8 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,6 ,0 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 }};
    Sudoku s5 = new Sudoku(t5);
    System.out.println(s5.solutionUnique());
    
    System.out.println("end");
  }

  public static void main(String a[]) {
    //test1();
    //test2();
    //test3();
    //test4();
    //test5();
    test6();
  }
}  
