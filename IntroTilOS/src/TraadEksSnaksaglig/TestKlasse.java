package TraadEksSnaksaglig;

public class TestKlasse {

    public static void main(String[] args) {

        SnaksagligPerson jacob = new SnaksagligPerson("Jacob", 100);
        SnaksagligPerson ulla = new SnaksagligPerson("Ulla", 100);
        SnaksagligPerson hans = new SnaksagligPerson("Hans", 100);
        Godmorgen godmorgen = new Godmorgen("Johnson",100,5);
        Velkommen velkommen = new Velkommen("Bob",20,15);
//        jacob.start();
//        ulla.start();
//        hans.start();
//        godmorgen.start();
        velkommen.start();

    }

}
