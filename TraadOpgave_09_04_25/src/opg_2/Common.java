package opg_2;

import java.util.concurrent.Semaphore;

public class Common {
private static int bestillinger = 0;
private static int færdigeBestillinger = 0;
private final Semaphore s = new Semaphore(1);
private final Semaphore s0 = new Semaphore(0);
public Common(){

}


    public  int getBestillinger() {
        return bestillinger;
    }

    public int getFærdigeBestillinger() {
        return færdigeBestillinger;
    }

    public void countBestillinger(){
        try {
            s.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        bestillinger++;
        System.out.println("bestillingsnummer er " + getBestillinger());


        s.release();
        s0.release();
    }

    public void countFærdigeBestillinger() throws InterruptedException {
    s0.acquire();

        færdigeBestillinger++;
        System.out.println("bestilling færdig " + getFærdigeBestillinger());



    }
}
