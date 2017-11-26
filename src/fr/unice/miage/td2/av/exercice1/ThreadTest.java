package fr.unice.miage.td2.av.exercice1;

public class ThreadTest {

    public static void main(String[] args) {

        new Thread(new Compte()).start();
        new Thread(new Decompte()).start();

    }
}
