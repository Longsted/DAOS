package concurrencyEksempler;

public class Monitor_eks {
    static class Monitor {
        private boolean inUse = false;

        public synchronized void enter() throws InterruptedException {
            while (inUse) {
                wait(); // Vent til sektionen er fri
            }
            inUse = true;
        }

        public synchronized void exit() {
            inUse = false;
            notify(); // Giv besked til en ventende tråd
        }
    }

    static Monitor monitor = new Monitor();

    static class Worker extends Thread {
        public void run() {
            try {
                monitor.enter();
                System.out.println(Thread.currentThread().getName() + " inde i kritisk sektion");
                Thread.sleep(1000);
                monitor.exit();
                System.out.println(Thread.currentThread().getName() + " forlod sektionen");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Worker().start();
        new Worker().start();
    }
}
