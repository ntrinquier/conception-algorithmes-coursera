/* Ceci est la classe des objets poss�dant une fonction de hash. Elle est
 * abstraite : � vous d'�crire des fichiers Objet1.java et Objet2.java pour
 * impl�menter vos propres versions ! */
public abstract class Objet {
    abstract int hash();
    abstract String nom();

    public boolean equals(Objet that) {
    	return this.nom().equals(that.nom());
    }
}
