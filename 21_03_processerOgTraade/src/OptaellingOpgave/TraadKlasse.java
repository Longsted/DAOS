package OptaellingOpgave;

public class TraadKlasse extends Thread{
private int start;
private int slut;
private int[]optaelling = new int[Optaelling.getMuligeNavne().length]; ;
private String[]stemmer;


    public TraadKlasse(int start, int slut, String[] stemmer) {
        this.start = start;
        this.slut = slut;
        this.stemmer = stemmer;
    }

    public void run(){
        for (int i = start; i <slut ; i++) {
            for(int j = 0; j< Optaelling.getMuligeNavne().length;j++){
                if(stemmer[i].equalsIgnoreCase(Optaelling.getMuligeNavne()[j])) {
                    optaelling[j]++;
                }
            }
        }
    }

    public int[] getOptaelling(){
        return optaelling;
    }
}
