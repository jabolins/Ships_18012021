import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ships ship = new Ships(); // atbildēs par kuģu izveidi, šāvienu trāpījumu pārbaudi
        Statistic statistic = new Statistic();// atbildēs par šāvinu uzskaiti

        boolean feasibilityShips; // pārbaude vai vispār var izveidot kuģus pēc norādītiem parametriem
        statistic.allShots = new ArrayList<>(); // sākam jaunu statistikas uzskaiti

        feasibilityShips = ship.createAllShips(10, 1, 1, 1, 1); // izveido visus kuģus un paziņo vai tas bija iespējams
        System.out.println("izveides rezultāts ir " + feasibilityShips); // šis pārbaudei. vēlāk jānomaina uz paziņojumu lietotājam ja nesanāk

        for (int i = 0; i < Ships.getAllShips().size(); i++) { // izdrukājam visus kuģus konsolē. tas pārbaudei un testiem. Vēlāk jāizdzēš
            System.out.print("Kuģa " + i + " vietas ir: ");
            for (int j = 0; j < Ships.getAllShips().get(i).getSize(); j++) {
                System.out.print(Ships.getAllShips().get(i).getArea()[j] + "; ");
            }
            System.out.println();
        } // tas pārbaudēm. Vēlāk jāizdzēš

        String resultOfSHot = ""; // lai būtu String jau kaut kāda vērtība
        while (!resultOfSHot.equals("beigas")) { // kamēr nebūs paziņojums no Ships ka visi kuģi nogremdēti tikmēr.....

            Scanner input = new Scanner(System.in);// šis vēlāk jāsaintegrē ar lietātja ievadi. Šis ir pagaidām
            System.out.println("ievadiet šāvienu");
            int shot = input.nextInt();

            if (statistic.newShotStatisticCheck(shot)) { // pārbaudām vai šāds šāviens jau nav bijis
                resultOfSHot = ship.shotTest(shot);
                System.out.println(resultOfSHot); // šis vēlāk jāsaliek ar lietotāja informēšanu grafiskā vidē
            } else {
                System.out.println("šāds šaviens jau bija");
            }
        }
    }
}
