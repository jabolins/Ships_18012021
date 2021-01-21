package statistic;

import dbManegment.DbManagement;

import java.util.ArrayList;

public class Statistic {
    int shot;

    private static String gamer; // spēlētājs kurš spēlēs konkrēto spēli
    public static String getGamer() {
        return gamer;
    }
    public static void setGamer(String gamer) {
        Statistic.gamer = gamer;
    }

    private static int gameCode; // vērtība spēles veida (ID) piefiksēšanai

    public static int getGameCode() {
        return gameCode;
    }
    public static void setGameCode(int gameCode) {
        Statistic.gameCode = gameCode;
    }


    public static ArrayList<Integer> getAllShots() { //  masīvs kurā būs reģistrēti visi šāvieni
        return allShots;
    }
    static ArrayList<Integer> allShots = new ArrayList<>();

    public static void fixGameDate(int fieldSize, int ship4, int ship3, int ship2, int ship1){
        String gameCodeString= String.valueOf(fieldSize)+ship4+ship3+ship2+ship1; // tādejādi mēs iegūstam skaitļu rindu
        gameCode= Integer.valueOf(gameCodeString);
        DbManagement dbManagement= new DbManagement();
        dbManagement.gameResultRegistration(gamer, gameCode,getAllShots().size());
        System.out.println("izdarīti tik šāvieni" + allShots.size());

        System.out.println("spēls kods ir" + gameCode); // tas ir tikai pārbaudei. Vēlāk jāizdzēš
    }

    public static boolean newShotStatisticCheck(int shot) { // te pārbaudīsim vai tāds šāviens ja nav bijis.
        // Tas vajadzīgs lai uzskaitītu tikai unikālos šāvienus
        for (int i : allShots) {
            if (i == shot) {
                return false;
            }
        }
        allShots.add(shot);
        return true;

    } // pārbaudām vai šāds šāviens jau nav bijis un atgriežam vai nu true ja viss labi vai false ja nav la
}
