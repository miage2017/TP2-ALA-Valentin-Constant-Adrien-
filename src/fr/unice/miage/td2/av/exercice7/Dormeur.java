package fr.unice.miage.td2.av.exercice7;

public class Dormeur implements Runnable {

    private String name;
    private Thread[] predecesseurs;

    public Dormeur(String name, Thread[] predecesseurs) {
        this.name = name;
        this.predecesseurs = predecesseurs;
    }

    @Override
    public void run() {
        for (Thread predec : predecesseurs) {
            try {
                predec.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Je suis " + this.name + " j'ai fini");

    }
}
