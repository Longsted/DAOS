package OptaellingOpgave;

import java.util.Random;

public class Optaelling {

    private static String[] muligeNavne = {"Allan", "Bodil", "Camilla", "Dorthe", "Erik", "Frede", "Gitte", "Henning", "Ib", "John"};

    private static int[] optaelling = new int[muligeNavne.length];

    private static int antalStemmer = 10000000;

    private static String[] stemmer = new String[antalStemmer];

    public static void optaelling() {
        for (String stemme : stemmer) {
            for (int i = 0; i < muligeNavne.length; i++) {
                if (stemme.equalsIgnoreCase(muligeNavne[i])) {
                    optaelling[i]++;
                }
            }
        }
    }

    public static void optaellingtraad() {
        TraadKlasse t1 = new TraadKlasse(0,stemmer.length/2,stemmer);
        TraadKlasse t2 = new TraadKlasse((stemmer.length/2)+1,stemmer.length,stemmer);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < optaelling.length; i++) {
            optaelling[i] = t1.getOptaelling()[i] + t2.getOptaelling()[i];
        }

    }

    public static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < stemmer.length; i++) {
            stemmer[i] = muligeNavne[random.nextInt(10)];
        }
    }

    public static void printArray() {
        for (int i = 0; i < stemmer.length; i++) {
            System.out.print(stemmer[i] + " ");
        }
        System.out.println();
    }

    public static void printOptaelling() {
        for (int i = 0; i < optaelling.length; i++) {
            System.out.println(muligeNavne[i] + " har fået " + optaelling[i] + " stemmer");
        }
    }

    public static String[] getMuligeNavne() {
        return muligeNavne;
    }

}
