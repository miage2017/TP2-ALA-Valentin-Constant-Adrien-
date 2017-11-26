package fr.unice.miage.td2.av.exercice1;

public class Compte implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("Compte : " + i);
        }
    }
}
