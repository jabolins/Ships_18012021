import gameStatistic.GameStatistic;
import playground.Playground;

import java.util.Scanner;

public class ShipsTestDrive {
    public static void main(String[] args) {

        Playground ship = new Playground();
        boolean izveidesRezultats;
        izveidesRezultats = ship.createAllShips(10, 1, 1, 1, 1);
        System.out.println("izveides rezultāts ir " + izveidesRezultats);

        for (int i = 0; i < Playground.getAllShips().size(); i++) { // izdrukājam visus kuģus
            System.out.print("Kuģa " + i + " vietas ir: ");
            for (int j = 0; j < Playground.getAllShips().get(i).getShipSize(); j++) {
                System.out.print(Playground.getAllShips().get(i).getShipFields()[j] + "; ");
            }
            System.out.println();
        }

        GameStatistic savienuStatistika = new GameStatistic();
        //savienuStatistika.setAllShots()= new ArrayList<>(); // kaut kas nav kārtība
        String savienaRezultats = ""; // lai būtu String jau kaut kāda vērtība
        while (!savienaRezultats.equals("beigas")) {
            Scanner ievade = new Scanner(System.in);
            System.out.println("ievadiet šāvienu");
            int saviens = ievade.nextInt();
            if (savienuStatistika.newShotStatisticCheck(saviens)) { // pārbaudām vai šāds šāviens jau nav bijis
                savienaRezultats = ship.shotTest(saviens);
                System.out.println(savienaRezultats);
            } else {
                System.out.println("šāds šaviens jau bija");
            }
        }
    }
}
