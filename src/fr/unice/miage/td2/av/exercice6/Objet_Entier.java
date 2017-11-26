package fr.unice.miage.td2.av.exercice6;

public class Objet_Entier {
    private int ma_valeur;

    public Objet_Entier(int valeur) {
        ma_valeur = valeur;
        System.out.format("Valeur partagee initialisee a %d\n", ma_valeur);
    }

    public String toString() {
        return Integer.toString(ma_valeur);
    }

    public int val() {
        return ma_valeur;
    }

    public synchronized void add(int i) {
        ma_valeur += i;
    }

}
