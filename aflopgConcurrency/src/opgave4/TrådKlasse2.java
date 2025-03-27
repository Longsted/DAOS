package opgave4;

public class TrådKlasse2 extends Thread {
    private String navn;
    private FællesKlasse fællesKlasse;

    public TrådKlasse2(String navn, FællesKlasse fællesKlasse) {
        this.navn = navn;
        this.fællesKlasse = fællesKlasse;
    }
    public void run() {
        for (int j=0; j<100;j++) {
            fællesKlasse.kritiskSection();
            fællesKlasse.tagerRandomTid(20);
        }
        System.out.println(fællesKlasse.getGlobal());
    }
}
