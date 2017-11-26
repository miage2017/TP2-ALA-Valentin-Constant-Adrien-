package fr.unice.miage.td2.av.exercice7;

public class TestDormeur {

    public static void main(String[] args) throws InterruptedException {
        Thread tc = new Thread(new Dormeur("C", new Thread[0]));
        Thread tb = new Thread(new Dormeur("B", new Thread[]{tc}));
        Thread ta = new Thread(new Dormeur("A", new Thread[]{tc, tb}));

        ta.start();
        tb.start();
        tc.start();

    }
}
