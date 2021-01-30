package playground;

public class ShipTestDrive {


    public static void main(String[] args) {
        Ship ship1 = new Ship(4);
        ship1.deployShip(ship1, 10);


        System.out.println("Ship 1 fields: ");
        for (int i = 0; i < ship1.getSize(); i++) {
            System.out.printf("%s ;", ship1.getFields()[i]);
        }
        System.out.println("");
        System.out.println("ship1 1 area: ");
        for (int i = 0; i < ship1.getFieldsAroundShip().length; i++) {
            System.out.printf("%s ;", ship1.getFieldsAroundShip()[i]);
        }

        System.out.println("");

        Ship ship2 = new Ship(2);
        ship2.deployShip(ship2, 10);
        System.out.println("Ship 2 fields: ");
        for (int i = 0; i < ship2.getSize(); i++) {
            System.out.printf("%s ;", ship2.getFields()[i]);
        }
        System.out.println("");
        System.out.println("ship 2 area: ");
        for (int i = 0; i < ship2.getFieldsAroundShip().length; i++) {
            System.out.printf("%s ;", ship2.getFieldsAroundShip()[i]);
        }
    }
}
