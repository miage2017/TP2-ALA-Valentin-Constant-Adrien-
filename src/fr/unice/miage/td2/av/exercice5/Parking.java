package fr.unice.miage.td2.av.exercice5;

import java.util.ArrayList;

public class Parking extends Thread {

    private int nbPlace;
    private Object monVerrou = new Object();

    private ArrayList<Voiture> lesVoitures;


    public Parking(int nbPlace) {
        this.nbPlace = nbPlace;
        lesVoitures = new ArrayList<>();
    }

    public boolean enter(Voiture voiture) {

        synchronized (monVerrou) {
            if (lesVoitures.size() < nbPlace) {
                System.out.println("Voiture #" + voiture.getIdentifiant() + " entre");
                lesVoitures.add(voiture);
                return true;
            } else {
                return false;
            }
        }
    }

    public void leave(Voiture voiture) {

        synchronized (monVerrou) {
            System.out.println("Voiture #" + voiture.getIdentifiant() + " sort");
            lesVoitures.remove(voiture);
        }
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("Voitures présentes:\n");
        for (Voiture voiture : lesVoitures) {
            str.append(voiture.getId() + "\n");
        }

        return str.toString();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (monVerrou) {
                System.out.println(this);
            }
        }
    }


}
