package playground;

public class ShipTestDrive {


    public static void main(String[] args) {
        Ship ship1 = new Ship(4);
        ship1.deployOfShip(ship1, 10);


        System.out.println("Ship 1 fields: ");
        for (int i = 0; i < ship1.size; i++) {
            System.out.printf("%s ;", ship1.fields[i]);
        }
        System.out.println("");
        System.out.println("ship1 1 area: ");
        for (int i = 0; i < ship1.fieldsAroundShip.length; i++) {
            System.out.printf("%s ;", ship1.fieldsAroundShip[i]);
        }

        System.out.println("");

        Ship ship2 = new Ship(2);
        ship2.deployOfShip(ship2, 10);
        System.out.println("Ship 2 fields: ");
        for (int i = 0; i < ship2.size; i++) {
            System.out.printf("%s ;", ship2.fields[i]);
        }
        System.out.println("");
        System.out.println("ship 2 area: ");
        for (int i = 0; i < ship2.fieldsAroundShip.length; i++) {
            System.out.printf("%s ;", ship2.fieldsAroundShip[i]);
        }
    }
}
