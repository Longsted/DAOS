package concurrencyEksempler;

public class Deadlock_eks {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Tråd 1 holder lock1 og venter på lock2...");
                try { Thread.sleep(100); } catch (Exception ignored) {}
                synchronized (lock2) {
                    System.out.println("Tråd 1 har begge locks");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Tråd 2 holder lock2 og venter på lock1...");
                try { Thread.sleep(100); } catch (Exception ignored) {}
                synchronized (lock1) {
                    System.out.println("Tråd 2 har begge locks");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
