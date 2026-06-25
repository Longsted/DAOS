package concurrencyEksempler;

public class Peterson_eks {
    static volatile boolean[] flag = new boolean[2]; // Vil gerne ind
    static volatile int turn; // Hvis tur er givet til den anden

    static class Worker extends Thread {
        int id; // 0 eller 1

        Worker(int id) {
            this.id = id;
        }

        public void run() {
            int other = 1 - id;
            for (int i = 0; i < 5; i++) {
                // Indgangsprotokol
                flag[id] = true;
                turn = other;
                while (flag[other] && turn == other) {
                    // Busy wait
                }

                // Kritisk sektion
                System.out.println("Tråd " + id + " i kritisk sektion");

                // Udgangsprotokol
                flag[id] = false;
            }
        }
    }

    public static void main(String[] args) {
        new Worker(0).start();
        new Worker(1).start();
    }
}
/*Bemærk: Denne løsning fungerer kun for to tråde, og
 *forudsætter synkroniseret adgang til shared memory.
* */
