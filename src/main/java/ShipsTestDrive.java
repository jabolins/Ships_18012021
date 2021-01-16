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

        String savienaRezultats = ""; // lai būtu String jau kaut kāda vērtība
        while (!savienaRezultats.equals("beigas")) {
            Scanner ievade = new Scanner(System.in);
            System.out.println("ievadiet šāvienu");
            int saviens = ievade.nextInt();
            savienaRezultats = ship.shotTest(saviens);
            System.out.println(savienaRezultats);
        }
    }
}
