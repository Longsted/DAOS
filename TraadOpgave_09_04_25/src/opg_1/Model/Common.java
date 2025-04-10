package opg_1.Model;

public class Common {
private static int bestillinger = 0;
private static int færdigeBestillinger = 0;

public Common(){

}

    public  int getBestillinger() {
        return bestillinger;
    }

    public int getFærdigeBestillinger() {
        return færdigeBestillinger;
    }

    public void countBestillinger(){
    bestillinger++;
    }

    public void countFærdigeBestillinger(){
    færdigeBestillinger++;
    }
}
