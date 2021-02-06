package gameStatistic;

import interfaces.StatisticManagment;
import java.util.ArrayList;
public class GameStatistic implements StatisticManagment {
    int shot;


    //private  int gameCode; // vērtība spēles veida (ID) piefiksēšanai

    private ArrayList<Integer> allShots = new ArrayList<>();



//    public void fixGameCode(int fieldSize, int ship4, int ship3, int ship2, int ship1){
//        String gameCodeString= String.valueOf(fieldSize)+ship4+ship3+ship2+ship1; // tādejādi mēs iegūstam skaitļu rindu
//        gameCode= Integer.valueOf(gameCodeString);
//        System.out.println("spēls kods ir" + gameCode); // tas ir tikai pārbaudei. Vēlāk jāizdzēš
//    }



    public boolean wasShotAlreadyBeen(int shot) { // te pārbaudīsim vai tāds šāviens ja nav bijis.
        for (int i : allShots) {
            if (i == shot) {
                return true;
            }
        }
        allShots.add(shot);
        return false;
    }
}
