package concurrencyEksempler;
import java.util.concurrent.Semaphore;


public class Semaphore_eks {
    static Semaphore semaphore = new Semaphore(1); // Kun 1 tråd ad gangen

    static class Worker extends Thread {
        public void run() {
            try {
                semaphore.acquire(); // Prøv at få adgang
                System.out.println(Thread.currentThread().getName() + " kører");
                Thread.sleep(1000); // Simulerer arbejde
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " er færdig");
                semaphore.release(); // Giv adgang videre
            }
        }
    }

    public static void main(String[] args) {
        new Worker().start();
        new Worker().start();
    }
}

