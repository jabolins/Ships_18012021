package playground;

import interfaces.GameManagement;

public class PlaygroundTestDrive {
    public static void main(String[] args) {


      GameManagement playground= new Playground(4,4,3,2,1);
        System.out.println("kuģu izveides rezultātāts ir " + playground.createPlaygroundWithShips((Playground) playground));
      playground.printAllShips();
//        GameManagment playground= new Playground();
//        System.out.println("kuģu izveides rezultāts ir "+ playground.createPlayground(playground));
//
//
//        for (int i=0; i<playground.getAllShips().size(); i++){
//            System.out.print(" kuģa "+ i + " vietas ir:");
//            printShipFields(i, playground);
//            System.out.println("");
//        }
//        testShotCheck(playground);
//    }
//
//    private static void testShotCheck(Playground playground) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("ievadiet šāvienu");
//        int shot= input.nextInt();
//        System.out.println(playground.checkShot(shot));
//
//    }
//
//    private static void printShipFields(int NrOfShip, Playground playground) {
//        for(int i=0; i<playground.getAllShips().get(NrOfShip).getSize(); i++ ){
//            System.out.print(playground.getAllShips().get(NrOfShip).getFields()[i]+ " ;");
//        }
//
//    }
//
//
// private static void printOcupiedArea(Playground playground){
//        System.out.println("aizņemtie laukumi ir ");
//        for (int i = 0; i<playground.getOccupiedFields().size(); i++){
//            System.out.print(playground.getOccupiedFields().get(i)+ "; ");
//        }
//
//
    }
}

