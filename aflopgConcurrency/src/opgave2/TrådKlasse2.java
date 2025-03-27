package opgave2;

public class TrådKlasse2 extends Thread {
    private String navn;
    private FællesKlasse fællesKlasse;

    public TrådKlasse2(String navn, FællesKlasse fællesKlasse) {
        this.navn = navn;
        this.fællesKlasse = fællesKlasse;
    }
    public void run() {

        for (int j=0; j<100;j++) {
            HovedKlasse.setFlag(1,true);
            HovedKlasse.setTurn(0);
            while(HovedKlasse.getFlag(0)&& HovedKlasse.getTurn() == 0){

            }
            fællesKlasse.kritiskSection();
            HovedKlasse.setFlag(1,false);
            fællesKlasse.tagerRandomTid(20);


        }
        System.out.println(fællesKlasse.getGlobal());
    }
}
