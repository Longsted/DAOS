package TraadEksSnaksaglig;

public class Godmorgen extends Thread{
    private String navn;
    private int ventetid;
    private boolean kører = false;
    private int iMax;

    public Godmorgen(String navn,int ventetid,int iMax){
        this.navn = navn;
        this.ventetid = ventetid;
        this.iMax = iMax;
    }

    public void run(){
        int i = 0;
        while(!kører){
            System.out.println(navn + " Godmorgen : " + i);
            try{
                Thread.sleep(ventetid);
                i++;
                if(i== iMax){
                    kører = true;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
