import ships.Ships;

import java.util.ArrayList;
import java.util.Scanner;

public class ShipsTestDrive {
    public static void main(String[] args) {

        Ships ship = new Ships();
        boolean izveidesRezultats;
        izveidesRezultats = ship.createAllShips(10, 1, 1, 1, 1);
        System.out.println("izveides rezultāts ir " + izveidesRezultats);

        for (int i = 0; i < Ships.getAllShips().size(); i++) { // izdrukājam visus kuģus
            System.out.print("Kuģa " + i + " vietas ir: ");
            for (int j = 0; j < Ships.getAllShips().get(i).getSize(); j++) {
                System.out.print(Ships.getAllShips().get(i).getArea()[j] + "; ");
            }
            System.out.println();
        }

        statistic.Statistic savienuStatistika = new statistic.Statistic();
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
