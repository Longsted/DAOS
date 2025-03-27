package opgave2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Lottoraek> Lotto = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            Lotto.add(new Lottoraek());


        }
        Lottoraek rigtige = new Lottoraek();
        long l1,l2;
        int[] antalRigtige = new int[8];
        l1 = System.nanoTime();
        for (int i = 0; i < Lotto.size(); i++) {
            antalRigtige[Lotto.get(i).antalrigtige(rigtige)]++;
        }
        l2 =System.nanoTime();
        System.out.println(Arrays.toString(antalRigtige));
        System.out.println("Køretiden er : " + (l2-l1)/1000000 + " sekunder");

    }
}
