package fr.unice.miage.td2.av.exercice1;

public class Decompte implements Runnable {
    @Override
    public void run() {
        for (int i = 1000; i >= 1; i--) {
            System.out.println("DeCompte : " + i);
        }
    }
}
