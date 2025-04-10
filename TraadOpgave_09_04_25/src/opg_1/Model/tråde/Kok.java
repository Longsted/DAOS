package opg_1.Model.tråde;

import opg_1.Model.Common;

public class Kok extends Thread{
    private Common common;

    public Kok(Common common) {
        this.common = common;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                common.countFærdigeBestillinger();
                Thread.sleep((int)Math.random() * 150 + 100);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("bestilling færdig " + common.getFærdigeBestillinger());

        }


    }



}
