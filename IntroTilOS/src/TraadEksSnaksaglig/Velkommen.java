package TraadEksSnaksaglig;

public class Velkommen extends Thread {
    private String velkommen;
    private int ventetid;
    private int imax;

    public Velkommen(String velkommen,int ventetid,int imax){
        this.velkommen = velkommen;
        this.ventetid = ventetid;
        this.imax = imax;
    }
    public void run(){
        for (int i = 1; i < imax + 1; i++) {
            try{
                System.out.println(velkommen + " : velkommen : " + i);
                Thread.sleep(ventetid);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
