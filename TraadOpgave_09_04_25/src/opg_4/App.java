package opg_4;

public class App {

    public static void main(String[] args) {

        Common common = new Common();

        Kok k1 = new Kok(common);
        Kok k2 = new Kok(common);
        Tjener t1 = new Tjener(common);
        Tjener t2  =new Tjener(common);

        t1.start();
        t2.start();
        k1.start();
        k2.start();

        try{
            t1.join();
            t2.join();
            k1.join();
            k2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
