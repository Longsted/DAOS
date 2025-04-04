package primtal;

import java.util.Random;

public class PrimtalOpgave extends Thread{


    public static void main(String[] args) {
        int count = 0;
        Long tidStart = System.currentTimeMillis();
        int[]primtal = new int[10000000];
        Random r = new Random();

        for(int i = 0; i<primtal.length; i++){
            primtal[i] = r.nextInt(100)+1;
        }
        for(int i = 0; i<primtal.length; i++){
            if(isPrime(primtal[i])){
            count++;
            }
        }


        Long tidSlut = System.currentTimeMillis();
        Long tidResultat = tidSlut-tidStart;
        System.out.println(count);
        System.out.println(tidResultat);
    }
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }



}
