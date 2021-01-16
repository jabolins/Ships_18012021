public class ShipsTestDrive {
    public static void main(String[] args){
Ships ship = new Ships();
boolean izveidesRezultats;
izveidesRezultats=  ship.createAllShips(4,1,2,3,4);
        System.out.println("izveides rezultāts ir "+ izveidesRezultats);
for (int i=0; i<Ships.getAllShips().size(); i++){
    System.out.print ("Kuģa " + i+ " vietas ir: ");
    for (int j=0; j<Ships.getAllShips().get(i).getSize(); j++){
        System.out.print(Ships.getAllShips().get(i).getArea()[j] + "; ");
    }
    System.out.println();
}
    }
}
