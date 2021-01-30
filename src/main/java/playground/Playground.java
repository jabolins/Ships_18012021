package playground;

import java.util.ArrayList;

public class Playground {

    private int shipSize; // noteiks cik lauciņus "garš" ir kuģis

    public int getShipSize() {
        return shipSize;
    }

    private int[] shipFields; // masīvs kurā ierakstīsim visus kuģa "lauciņus"

    public int[] getShipFields() {
        return shipFields;
    }

    private int[] fieldsAroundShip; // masīvs kurā ierakstīsim visus lauciņus kas ir apkārt kuģim lai tur nevarētu izvietot citus kuģus
    private int numberOfHits; // katram kuģim skaitīsim cik reizes ir trāpīts lai zinātu kad grimst
    private static ArrayList<Playground> allShips = new ArrayList<>();// masīvs kurā reģistrēsim visus kuģus

    public static ArrayList<Playground> getAllShips() {
        return allShips;
    }

    private static ArrayList<Integer> occupiedFields = new ArrayList<>();
    // vieta kur reģistrēsim visu kuģu aizņemtās platības

    private static int numberOfSunkShips; // izmantosim lai skaitītu nogrimušos kuģus


    public boolean createAllShips(int playgroundSize, int numberOfShipsSize4,// šo jāpārsauc savādāk
                                  int numberOfShipsSize3, int numberOfShipsSize2, int numberOfShipsSize1) {
        allShips.clear();
        numberOfSunkShips = 0;
        boolean resultCreateAllShips = false;

        createAllVariablesShip(numberOfShipsSize4, numberOfShipsSize3, numberOfShipsSize2, numberOfShipsSize1);

        int numberOfAttempts = 0;

        while (createShips(playgroundSize) == true || numberOfAttempts == 100) {
        }
        if (numberOfAttempts == 100) {
            resultCreateAllShips = false;
        }
        else resultCreateAllShips= true;

        return resultCreateAllShips;
    }

    private void createAllVariablesShip(int numberOfShipsSize4, int numberOfShipsSize3, int numberOfShipsSize2, int numberOfShipsSize1) {
        for (int i = 0; i < numberOfShipsSize4; i++) {
            Playground ship = new Playground(); // saliekam sākuma parametrus
            ship.shipSize = 4;
            ship.shipFields = new int[4];
            ship.fieldsAroundShip = new int[18];
            ship.numberOfHits = 0;

            allShips.add(ship); // pievienojam jauno kuģi visu kuģu masīvam
        } // reģistrējam visus kuģus ar garumu 4 lauciņi

        for (int i = 0; i < numberOfShipsSize3; i++) {
            Playground ship = new Playground(); // saliekam sākuma parametrus
            ship.shipSize = 3;
            ship.shipFields = new int[3];
            ship.fieldsAroundShip = new int[15];
            ship.numberOfHits = 0;

            allShips.add(ship); // pievienojam jauno kuģi visu kuģu masīvam
        } // reģistrējam visus kuģus ar garumu 3 lauciņi

        for (int i = 0; i < numberOfShipsSize2; i++) {
            Playground ship = new Playground(); // saliekam sākuma parametrus
            ship.shipSize = 2;
            ship.shipFields = new int[2];
            ship.fieldsAroundShip = new int[12];
            ship.numberOfHits = 0;

            allShips.add(ship); // pievienojam jauno kuģi visu kuģu masīvam
        } // reģistrējam visus kuģus ar garumu 2 lauciņi

        for (int i = 0; i < numberOfShipsSize1; i++) {
            Playground ship = new Playground(); // saliekam sākuma parametrus
            ship.shipSize = 1;
            ship.shipFields = new int[1];
            ship.fieldsAroundShip = new int[9];
            ship.numberOfHits = 0;

            allShips.add(ship); // pievienojam jauno kuģi visu kuģu masīvam
        } // reģistrējam visus kuģus ar garumu 1 lauciņš
    }


    private boolean createShips(int playgroundSize) {
        boolean resultCreateOneShip = true;
boolean comaparAgainstOccupiedAreas= false;
int numberOfAttempts=0;

        while (comaparAgainstOccupiedAreas== true || numberOfAttempts==100)
            if (determineDirection().equals("horizontal")){
                assignFieldsToShip("horizontal");
        }
        else{
            assignFieldsToShip("vertical");
        }
        return resultCreateOneShip;
    }

    private void assignFieldsToShip(String direction) {
        int startFieldHorizontally;
        int startFieldVertically;
        if (direction.equals("horizontal")){
startFieldHorizontally=(int)(Math.random()*(3));
        }
        else{}
    }

    private String determineDirection() {
        String direction;
        if ((int) (Math.random() * 2 + 1) % 2 == 0){
            direction= "horizontal";
        }
        else{
            direction= "vertical";
        }
        return direction;
    }


    private boolean createOneShip(int shipNr, int fieldSize) {
        boolean result = false; // sākumā pieņemam ka nesanāks
        for (int shipAttemptsNr = 0; shipAttemptsNr < 100 && !result; shipAttemptsNr++) { // mēģinām 100 reizes vai arī līdz rezultāts ir OK
            int occupiedAreaNr = 0; // būs vajadzīgs vēlāk "reģistrējot" occupiedArea
// nosakām kuģa virzienu

            result = checkShip(shipNr);

        }
        return result;
    } // metode konkrēta viena kuģa izveidei un
    // atdodam rezultātu tas ir iespējams vai nē. Izmantosim arī metodi CheckShip

    private boolean checkShip(int shipNr) {
        for (int i : occupiedFields) { // izejam cauri visam masīvam
            for (int j = 0; j < allShips.get(shipNr).shipSize; j++) {
                if (i == allShips.get(shipNr).shipFields[j]) {
                    return false; // ja atrodam kaut vienu sakritību, pārtraucam darbu
                }
            }
        }
        for (int i = 0; i < allShips.get(shipNr).fieldsAroundShip.length; i++) {
            occupiedFields.add(allShips.get(shipNr).fieldsAroundShip[i]); // ja izveidošana bija veiksmīga, pievienojam aizņemto lauciņu sarakstam jaunu sarakstu
        }
        return true; // ja nevienu skaritību neatrada tad atgriež sākotnēji paredzēto vērtību true
    } // Metode lai pārbaudītu vai laukums kurā gatavojamies izvietot kuģi jau nav aizņemts

    public static String shotTest(int shotField) {
        String result = "garām"; // sākumā pieņemam ka ir garām
        for (int i = 0; i < allShips.size(); i++) {
            for (int j = 0; j < allShips.get(i).shipSize; j++) {
                if (shotField == allShips.get(i).shipFields[j]) { // ja atradām sakritību
                    allShips.get(i).numberOfHits++; // palielinām trāpījumu skaitu
                    if (allShips.get(i).numberOfHits == allShips.get(i).shipSize) {
                        numberOfSunkShips++;
                        if (numberOfSunkShips == allShips.size()) { // ja nogremdēto kuģu skaits ir vienāds ar visu kuģu skaitu- paziņojam ka viss beidies
                            result = "beigas";
                            return result;
                        } else {
                            result = "grimst";
                            return result;
                        }
                    } else {
                        result = "trāpīts";
                        return result;
                    }
                }
            }
        }
        return result;
    } // pārbauda šāviena vietu un atgriež vērtību- garām, trāpīts, grimst, beigas

    public static int findShip(int shot) {
        for (int i = 0; i < allShips.size(); i++) {
            for (int j = 0; j < allShips.get(i).shipSize; j++) {
                if (shot == allShips.get(i).shipFields[j]) { // ja atradām sakritību
                    return i;
                }
            }
        }
        return -1;
    }
}
