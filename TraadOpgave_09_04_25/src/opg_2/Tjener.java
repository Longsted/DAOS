package opg_2;

import java.util.concurrent.Semaphore;

public class Tjener extends Thread {
    private Common common;
    public Tjener(Common common) {
        this.common = common;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {

                common.countBestillinger();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }


    }
}
