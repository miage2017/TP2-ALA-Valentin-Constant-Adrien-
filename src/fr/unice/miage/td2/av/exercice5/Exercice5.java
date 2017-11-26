package fr.unice.miage.td2.av.exercice5;

public class Exercice5 {

    public static void main(String[] args) throws InterruptedException {

        Parking park = new Parking(10);
        Voiture[] lesVoitures = new Voiture[20];

        for (int i = 0; i < lesVoitures.length; i++) {
            lesVoitures[i] = new Voiture("PEX" + i, park);
            lesVoitures[i].start();
        }

        park.start();


    }
}
