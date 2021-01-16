import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ships ship = new Ships();
        Statistic statistic = new Statistic();

        boolean feasibilitieShips;
        statistic.allShots = new ArrayList<>();

        feasibilitieShips = ship.createAllShips(10, 1, 1, 1, 1);
        System.out.println("izveides rezultāts ir " + feasibilitieShips); // šis pārbaudei. vēlāk jānomaina uz paziņojumu lietotājam ja nesanāk

        for (int i = 0; i < Ships.getAllShips().size(); i++) { // izdrukājam visus kuģus. tas pārbaudei un testiem. Vēlāk jāizdzēš
            System.out.print("Kuģa " + i + " vietas ir: ");
            for (int j = 0; j < Ships.getAllShips().get(i).getSize(); j++) {
                System.out.print(Ships.getAllShips().get(i).getArea()[j] + "; ");
            }
            System.out.println();
        }

        String savienaRezultats = ""; // lai būtu String jau kaut kāda vērtība
        while (!savienaRezultats.equals("beigas")) {

            Scanner ievade = new Scanner(System.in);// šis vēlāk jāsaintegrē ar lietātja ievadi. Šis ir pagaidām
            System.out.println("ievadiet šāvienu");
            int saviens = ievade.nextInt();

            if (statistic.newShotStatisticCheck(saviens)) { // pārbaudām vai šāds šāviens jau nav bijis
                savienaRezultats = ship.shotTest(saviens);
                System.out.println(savienaRezultats); // šis vēlāk jāsaliek ar lietotāja informēšanu grafiskā vidē
            } else {
                System.out.println("šāds šaviens jau bija");
            }
        }
    }
}
