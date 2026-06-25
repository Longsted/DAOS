package concurrencyEksempler;

public class LøsDeadlock_eks {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " fik lock1");
                try { Thread.sleep(50); } catch (Exception ignored) {}
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " fik lock2");
                }
            }
        };

        new Thread(task, "Tråd A").start();
        new Thread(task, "Tråd B").start();
    }
}
