package opgave2;

public class TrådKlasse extends Thread{
    private String navn;
    private FællesKlasse fællesKlasse;


    public TrådKlasse(String navn, FællesKlasse fællesKlasse) {
        this.navn = navn;
        this.fællesKlasse = fællesKlasse;
    }
    public void run() {

        for (int j=0; j<100;j++) {
            HovedKlasse.setFlag(0,true);
            HovedKlasse.setTurn(1);
            while(HovedKlasse.getFlag(1)&& HovedKlasse.getTurn() == 1){

            }
            fællesKlasse.kritiskSection();
            HovedKlasse.setFlag(0,false);
            fællesKlasse.tagerRandomTid(200);


        }

        System.out.println(fællesKlasse.getGlobal());
    }
}
