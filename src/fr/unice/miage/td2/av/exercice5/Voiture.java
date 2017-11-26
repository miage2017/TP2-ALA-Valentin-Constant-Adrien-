package fr.unice.miage.td2.av.exercice5;

public class Voiture extends Thread {
    private String identifiant;
    private Parking park;

    public Voiture(String identifiant, Parking park) {
        this.identifiant = identifiant;
        this.park = park;
    }

    public void run() {
        while (true) {
            if (park.enter(this)) {
                try {
                    Thread.sleep(2000 + (int) Math.random() * (2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                park.leave(this);
            } else {
                System.out.println("Voiture #" + this.getIdentifiant() + " attend");
            }
            try {
                Thread.sleep(1000 + (int) Math.random() * (3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getIdentifiant() {
        return identifiant;
    }
}
