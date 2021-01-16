import java.util.ArrayList;

public class Ships {
    private int size; // noteiks cik lauciņus "garš" ir kuģis
    private int[] area; // masīvs kurā ierakstīsim visus kuģa "lauciņus"
    private int[] occupiedArea; // masīvs kurā ierakstīsim visus lauciņus kas ir apkārt kuģim lai tur nevarētu izvietot citus kuģus
    private int hitsCount; // katram kuģim skaitīsim cik reizes ir trāpīts lai zinātu kad grimst
    private static ArrayList<Ships> allShips = new ArrayList<>();// masīvs kurā reģistrēsim visus kuģus
    private static ArrayList<Integer> occupiedFields = new ArrayList<>(); // vieta kur reģistrēsim visu kuģu aizņemtās platības


    public boolean createShips(int gameFieldSize, int ship4count,
                               int ship3count, int ship2count, int ship1count) {//

        occupiedFields.clear();
        allShips.clear(); // sākam visu no sākuma

        boolean result = true; // sākotnēji pieņemam ka izveiedot neizdosies

        for (int i = 0; i < ship4count; i++) {
            Ships ship = new Ships(); // saliekam sākuma parametrus
            ship.size = 4;
            ship.area = new int[4];
            ship.occupiedArea = new int[18];
            ship.hitsCount = 0;

            allShips.add(ship); // pievienojam jauno kuģi visu kuģu masīvam
        } // reģistrējam visus kuģus ar garumu 4 lauciņi

        for (int i = 0; i < ship3count; i++) {
            Ships ship = new Ships(); // saliekam sākuma parametrus
            ship.size = 3;
            ship.area = new int[3];
            ship.occupiedArea = new int[15];
            ship.hitsCount = 0;

            allShips.add(ship); // pievienojam jauno kuģi visu kuģu masīvam
        } // reģistrējam visus kuģus ar garumu 3 lauciņi

        for (int i = 0; i < ship2count; i++) {
            Ships ship = new Ships(); // saliekam sākuma parametrus
            ship.size = 2;
            ship.area = new int[2];
            ship.occupiedArea = new int[12];
            ship.hitsCount = 0;

            allShips.add(ship); // pievienojam jauno kuģi visu kuģu masīvam
        } // reģistrējam visus kuģus ar garumu 2 lauciņi

        for (int i = 0; i < ship1count; i++) {
            Ships ship = new Ships(); // saliekam sākuma parametrus
            ship.size = 1;
            ship.area = new int[1];
            ship.occupiedArea = new int[9];
            ship.hitsCount = 0;

            allShips.add(ship); // pievienojam jauno kuģi visu kuģu masīvam
        } // reģistrējam visus kuģus ar garumu 1 lauciņš

// te vajag ciklu kamēr rezultāts nav true
        occupiedFields.clear(); // sākam no sākuma
        for (int i = 0; i < allShips.size(); i++) {
            createShip(i);
        }


        return result;
    }

    private boolean createShip(int shipNr) {

        boolean result = false;


        System.out.println("visu kuģu masīva izmērs ir " + allShips.size());


        return result;
    }

}
