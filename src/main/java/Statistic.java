import java.util.ArrayList;

public class Statistic {
    int shot;
    ArrayList<Integer> allShots;

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
