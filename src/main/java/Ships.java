import java.util.ArrayList;

public class Ships {

    private int size; // noteiks cik lauciņus "garš" ir kuģis

    public int getSize() {
        return size;
    }

    private int[] area; // masīvs kurā ierakstīsim visus kuģa "lauciņus"

    public int[] getArea() {
        return area;
    }

    private int[] occupiedArea; // masīvs kurā ierakstīsim visus lauciņus kas ir apkārt kuģim lai tur nevarētu izvietot citus kuģus
    private int hitsCount; // katram kuģim skaitīsim cik reizes ir trāpīts lai zinātu kad grimst
    private static ArrayList<Ships> allShips = new ArrayList<>();// masīvs kurā reģistrēsim visus kuģus

    public static ArrayList<Ships> getAllShips() {
        return allShips;
    }

    private static ArrayList<Integer> occupiedFields = new ArrayList<>(); // vieta kur reģistrēsim visu kuģu aizņemtās platības
    private static int sunkenShip; // izmantosim lai skaitītu nogrimušos kuģus

    public boolean createAllShips(int gameFieldSize, int ship4count,
                                  int ship3count, int ship2count, int ship1count) {//

        allShips.clear(); // sākam visu no sākuma
        sunkenShip = 0;

        boolean result = false; // sākotnēji pieņemam ka izveiedot neizdosies
// piešķiram visiem kuģiem vietu atmiņā un reģistrējam kopējā kuģu masīvā
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

// sākam kuģiem "piešķirt" laukumus
        for (int attemptsNr = 0; attemptsNr < 100 && !result; attemptsNr++) { // mēģināsim 100 reizes vai arī tikko rezultāts būs OK
            occupiedFields.clear(); // sākam no sākuma
            result = true; // tā kā nākošais cikls notiek tik ilgi kamēr neparādās rezultāts false, ieliekam sākumā ok

            for (int i = 0; i < allShips.size() && result; i++) { // izejam cauri visiem kuģiem vai arī līdz vienu kuģi izveidot neizdodas
                System.out.println("sākam kuģi " + i);// šis pārbaudei. Vēlāk jāizdzēš
                result = createOneShip(i, gameFieldSize); // izveidojam katru konkrēto kuģi un atgriežam vērtību to varēja vai nē
                System.out.println("kuģa " + i + " izveidošanas rezultāts ir " + result); // šis ir pārbaudei. Vēlāk jāidzēš
            }
            System.out.println("lielo mēģinājumu skaits = " + attemptsNr); // šis ir pārbaudei. vēlāk jāidzēš
        }
        if (!result) {
            allShips.clear();// ja nesanāca izveidot, drošības pēc izdzēšam visu masīvu
        }
        return result;
    } // te tiek veidoti visi kuģi un
    // atdodam rezultātu tas bija iespējams vai nē. To veidošanai izmantosim metodes CreateOneShip

    private boolean createOneShip(int shipNr, int fieldSize) {
        boolean result = false; // sākumā pieņemam ka nesanāks
        for (int shipAttemptsNr = 0; shipAttemptsNr < 100 && !result; shipAttemptsNr++) { // mēģinām 100 reizes vai arī līdz rezultāts ir OK
            int occupiedAreaNr = 0; // būs vajadzīgs vēlāk "reģistrējot" occupiedArea
// nosakām kuģa virzienu
            if ((int) (Math.random() * 2 + 1) % 2 == 0) {// šis būs horizontālais
                int startX = (int) (Math.random() * (fieldSize - allShips.get(shipNr).size)); // lai kuģis "neizietu ārpus laukuma" sākuma
                // pozīcijai ieliekam ierobežojumu no "kreisās malas" kuģa garumā
                int startY = (int) (Math.random() * fieldSize);

                for (int i = 0; i < allShips.get(shipNr).size; i++) {
                    allShips.get(shipNr).area[i] = startX + i + startY * 100; // katrs kuģa lauciņš būs skaitlis iegūts no
                    // x koordinātes (0, 1, 2, 3) un y koordinātes (0, 100, 200 utt)
                }
                for (int i = 0; i < allShips.get(shipNr).size + 2; i++) { // reģistrējam lauciņus apārt kuģim kuros nevar būt citi kuģi
                    for (int j = 0; j < 3; j++) {
                        allShips.get(shipNr).occupiedArea[occupiedAreaNr] = startX - 1 + i + (startY - 1 + j) * 100;
                        occupiedAreaNr++;
                    }
                }
            } else { // šis būs vertikālais virziens
                int startX = (int) (Math.random() * fieldSize);
                // pozīcijai ieliekam ierobežojumu no "kreisās malas" kuģa garumā
                int startY = (int) (Math.random() * (fieldSize - allShips.get(shipNr).size));// lai kuģis "neizietu ārpus laukuma" sākuma

                for (int i = 0; i < allShips.get(shipNr).size; i++) {
                    allShips.get(shipNr).area[i] = startX + (startY + i) * 100; // katrs kuģa lauciņš būs skaitlis iegūts no
                    // x koordinātes (0, 1, 2, 3) un y koordinātes (0, 100, 200 utt)
                }
                for (int i = 0; i < allShips.get(shipNr).size + 2; i++) { // reģistrējam lauciņus apārt kuģim kuros nevar būt citi kuģi
                    for (int j = 0; j < 3; j++) {
                        allShips.get(shipNr).occupiedArea[occupiedAreaNr] = startX - 1 + j + (startY - 1 + i) * 100;
                        occupiedAreaNr++;
                    }
                }
            }
            result = checkShip(shipNr);

        }
        return result;
    } // metode konkrēta viena kuģa izveidei un
    // atdodam rezultātu tas ir iespējams vai nē. Izmantosim arī metodi CheckShip

    private boolean checkShip(int shipNr) {
        boolean checkShipResult = true;
        for (int i : occupiedFields) { // izejam cauri visam masīvam
            for (int j = 0; j < allShips.get(shipNr).size; j++) {
                if (i == allShips.get(shipNr).area[j]) {
                    return false; // ja atrodam kaut vienu sakritību, pārtraucam darbu
                }
            }
        }
        for (int i = 0; i < allShips.get(shipNr).occupiedArea.length; i++) {
            occupiedFields.add(allShips.get(shipNr).occupiedArea[i]); // ja izveidošana bija veiksmīga, pievienojam aizņemto lauciņu sarakstam jaunu sarakstu
        }
        return true; // ja nevienu skaritību neatrada tad atgriež sākotnēji paredzēto vērtību true
    } // Metode lai pārbaudītu vai laukums kurā gatavojamies izvietot kuģi jau nav aizņemts

    public String shotTest(int shotField) {
        String result = "garām"; // sākumā pieņemam ka ir garām
        for (int i = 0; i < allShips.size(); i++) {
            for (int j = 0; j < allShips.get(i).size; j++) {
                if (shotField == allShips.get(i).area[j]) { // ja atradām sakritību
                    allShips.get(i).hitsCount++; // palielinām trāpījumu skaitu
                    if (allShips.get(i).hitsCount == allShips.get(i).size) {
                        sunkenShip++;
                        if (sunkenShip == allShips.size()) { // ja nogremdēto kuģu skaits ir vienāds ar visu kuģu skaitu- paziņojam ka viss beidies
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
}
