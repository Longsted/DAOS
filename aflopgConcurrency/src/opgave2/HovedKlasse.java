package opgave2;

public class HovedKlasse {
    private static boolean[] flag = new boolean[2];
    private static volatile int turn;
    public static void main(String[] args) {

        flag[0] = false;
        flag[1] = false;
        turn = 1;
        FællesKlasse f = new FællesKlasse();
        Thread t1 = new TrådKlasse("T1",f);
        Thread t2 = new TrådKlasse2("T2",f);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean getFlag(int index) {
        return flag[index];
    }

    public static int getTurn() {
        return turn;
    }

    public static void setFlag(int index,boolean b){
        flag[index] = b;
    }
    public static void setTurn(int setValue){
        turn = setValue;
    }
}
