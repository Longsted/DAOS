package opg_4;

public class Kok extends Thread{
    private Common common;

    public Kok(Common common) {
        this.common = common;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                common.countFærdigeBestillinger();
                Thread.sleep(400);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }



}
