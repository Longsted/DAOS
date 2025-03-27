package opgave4;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class FællesKlasse {
    private int global = 0;
    private Semaphore s = new Semaphore(1);

    public void tagerRandomTid(int max) {

        Random r = new Random();
        int nymax = Math.abs(r.nextInt()) % max + 1;

        for (int i = 0; i < nymax; i++) {
            for (int j = 0; j < nymax; j++) {
                int n = 200000;
                int a = 450000;
                int b = n + a;
                b = n - a;
            }

        }


    }

    public int getGlobal() {
        return global;
    }

    public void kritiskSection() {
        try {
            s.acquire();

            int temp;
            temp = global;
            tagerRandomTid(100);
            global = temp + 1;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        s.release();

    }
}
