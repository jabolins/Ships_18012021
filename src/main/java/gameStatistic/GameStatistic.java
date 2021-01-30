package gameStatistic;

import dbManegment.DbManagement;

import java.util.ArrayList;

public class GameStatistic {
    int shot;

    public String getGamer() {
        return gamer;
    }

    private  String gamer; // spēlētājs kurš spēlēs konkrēto spēli

    private  int gameCode; // vērtība spēles veida (ID) piefiksēšanai

    private ArrayList<Integer> allShots = new ArrayList<>();



    public void fixGameCode(int fieldSize, int ship4, int ship3, int ship2, int ship1){
        String gameCodeString= String.valueOf(fieldSize)+ship4+ship3+ship2+ship1; // tādejādi mēs iegūstam skaitļu rindu
        gameCode= Integer.valueOf(gameCodeString);
        System.out.println("spēls kods ir" + gameCode); // tas ir tikai pārbaudei. Vēlāk jāizdzēš
    }

    public boolean newShotStatisticCheck(int shot) { // te pārbaudīsim vai tāds šāviens ja nav bijis.
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
