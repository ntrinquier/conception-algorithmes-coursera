/* Ceci est la classe des objets possédant une fonction de hash. Elle est
 * abstraite : à vous d'écrire des fichiers Objet1.java et Objet2.java pour
 * implémenter vos propres versions ! */
public abstract class Objet {
    abstract int hash();
    abstract String nom();

    public boolean equals(Objet that) {
    	return this.nom().equals(that.nom());
    }
}
