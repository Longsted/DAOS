package opg_4;

public class Common {
    private static int bestillinger = 0;
    private static int færdigeBestillinger = 0;

    public Common() {

    }

    public int getBestillinger() {
        return bestillinger;
    }

    public int getFærdigeBestillinger() {
        return færdigeBestillinger;
    }

    public synchronized void countBestillinger() throws InterruptedException {

        bestillinger++;
        System.out.println("bestillingsnummer er " + getBestillinger());
        notifyAll();
    }

    public synchronized void countFærdigeBestillinger() throws InterruptedException {
//        while (færdigeBestillinger >= bestillinger) {
            wait();
//        }
        færdigeBestillinger++;
        System.out.println("bestilling færdig " + getFærdigeBestillinger());


    }
}
