package opg_1.Model.tråde;

import opg_1.Model.Common;

public class Tjener extends Thread {
    private Common common;

    public Tjener(Common common) {
        this.common = common;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                common.countBestillinger();
                Thread.sleep((int)Math.random() * 150 + 100);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("bestillingsnummer er " + common.getBestillinger());


        }


    }
}
