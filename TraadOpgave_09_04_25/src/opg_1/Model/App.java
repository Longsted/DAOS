package opg_1.Model;

import opg_1.Model.tråde.Kok;
import opg_1.Model.tråde.Tjener;

public class App {

    public static void main(String[] args) {

        Common common = new Common();

        Kok k1 = new Kok(common);

        Tjener t1 = new Tjener(common);
        Tjener t2  =new Tjener(common);

        t1.start();
        t2.start();
        k1.start();


        try{
            t1.join();
            t2.join();
            k1.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
