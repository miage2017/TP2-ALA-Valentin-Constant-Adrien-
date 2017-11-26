package fr.unice.miage.td2.av.exercice6;

public class Petit_Job implements Runnable {
    private Objet_Entier notre_entier;
    private int increment;

    Petit_Job(Objet_Entier notre_entier, int increment) {
        this.increment = increment;
        this.notre_entier = notre_entier;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            notre_entier.add(increment);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Objet_Entier Compteur = new Objet_Entier(0);
        Petit_Job objex1 = new Petit_Job(Compteur, 1);
        Petit_Job objex2 = new Petit_Job(Compteur, -1);
        Thread tache1 = new Thread(objex1, "incrementeur");
        Thread tache2 = new Thread(objex2, "decrementeur");

        tache1.start();
        tache2.start();

        System.out.format("Le compteur vaut %s\n", Compteur);
        tache1.join();
        tache2.join();
        System.out.format("Le compteur vaut %s\n", Compteur);
    }
}