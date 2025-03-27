package opgave4;

public class HovedKlasse {

    public static void main(String[] args) {
        FællesKlasse f = new FællesKlasse();
        Thread t1 = new TrådKlasse("T1",f);
        Thread t2 = new TrådKlasse2("T2",f);

        t1.start();
        t2.start();

    }
}
