package opgave2;

import java.util.Random;

public class FællesKlasse {
    private int global = 0;


    public void tagerRandomTid(int max){
        Random r = new Random();
        int nymax = Math.abs(r.nextInt())% max +1;

        for (int i = 0; i < nymax; i++){
            for(int j = 0; j < nymax;j++){
                int n = 200000;
                int a = 450000;
                int b = n+a;
               int c = n-a;
            }
        }

    }
    public int getGlobal() {
        return global;
    }
    public void kritiskSection(){
        int temp;
        temp = global;
        tagerRandomTid(100);
        global = temp + 1;
    }

}
