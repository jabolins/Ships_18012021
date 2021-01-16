import java.util.ArrayList;

public class Statistic {
    int shot;
    ArrayList<Integer> allShots;

    public boolean newShotStatisticCheck(int shot) { // te pārbaudīsim vai tāds šāviens ja nav bijis.
        // Tas vajadzīgs lai uzskaitītu tikai unikālos šāvienus
        boolean result = true;
        for (int i : allShots) {
            if (i == shot) {
                result = false;
                return result;
            }
        }
        allShots.add(shot);
        return result;
    } // pārbaudām vai šāds šāviens jau nav bijis un atgriežam vai nu true ja viss labi vai false ja nav la
}
