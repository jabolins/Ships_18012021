package playground;

import interfaces.GameManagment;

import java.util.ArrayList;

public class Playground implements GameManagment {

    private int playgroundSize;
    private int numberOfSize1Ships;
    private int numberOfSize2ships;
    private int numberOfSize3ships;
    private int numberOfSize4ships;

    private int numberOfSunkenShip;
    private final ArrayList<Integer> occupiedFields = new ArrayList<>();

    public Playground() {

    }

    public ArrayList<Ship> getAllShips() {
        return allShips;
    }
    private ArrayList<Ship> allShips = new ArrayList<>();

    public Playground(int playgroundSize,
                      int numberOfSize1Ships,
                      int numberOfSize2ships,
                      int numberOfSize3ships,
                      int numberOfSize4ships) {
        this.playgroundSize = playgroundSize;
        this.numberOfSize1Ships = numberOfSize1Ships;
        this.numberOfSize2ships = numberOfSize2ships;
        this.numberOfSize3ships = numberOfSize3ships;
        this.numberOfSize4ships = numberOfSize4ships;
    }



    public boolean createPlayground(int playgroundSize,
                                    int numberOfSize1Ships,
                                    int numberOfSize2ships,
                                    int numberOfSize3ships,
                                    int numberOfSize4ships) {
        Playground playground= new Playground(playgroundSize, numberOfSize1Ships,numberOfSize2ships,numberOfSize3ships,numberOfSize4ships);

        createArrayAllShips(numberOfSize4ships, numberOfSize3ships, numberOfSize2ships, numberOfSize1Ships);

        boolean isPossibleCreatePlayground = false;
        int numberOfAttempts = 0;
        while (!isPossibleCreatePlayground && numberOfAttempts < 100) {
            isPossibleCreatePlayground = createShips(playground);
            numberOfAttempts++;
        }
        return isPossibleCreatePlayground;
    }
    private void createArrayAllShips(int size4Ships, int size3Ships, int size2Ships, int size1Ships) {
        for (int i = 0; i < size4Ships; i++) {
            Ship ship = new Ship(4);
            allShips.add(ship);
        }
        for (int i = 0; i < size3Ships; i++) {
            Ship ship = new Ship(3);
            allShips.add(ship);
        }
        for (int i = 0; i < size2Ships; i++) {
            Ship ship = new Ship(2);
            allShips.add(ship);
        }
        for (int i = 0; i < size1Ships; i++) {
            Ship ship = new Ship(1);
            allShips.add(ship);
        }
    }
    public boolean createShips(Playground playground) {

        for (Ship allShip : allShips) {
            boolean isCoincidenceWithOccupiedAreas = true;
            int numberOfAttempts = 0;

            while (isCoincidenceWithOccupiedAreas && numberOfAttempts < 100) {
                allShip.deployShip(allShip, playgroundSize);

                isCoincidenceWithOccupiedAreas = checkOccupiedFields(allShip);
                numberOfAttempts++;
            }
            if (isCoincidenceWithOccupiedAreas) {
                return false;
            } else {
                for (int j = 0; j < allShip.getFieldsAroundShip().length; j++) {
                    occupiedFields.add(allShip.getFieldsAroundShip()[j]);
                }
            }
        }
        return true;
    }
    private boolean checkOccupiedFields(Ship ship) {
        for (int occupiedField : occupiedFields) {
            for (int nrOfShipField = 0; nrOfShipField < ship.getSize(); nrOfShipField++) {
                if (occupiedField == ship.getFields()[nrOfShipField]) {
                    return true;
                }
            }
        }
        return false;
    }

    public String checkShot(int shot) {
        for (Ship ship : allShips) {
            for (int fieldOfShip : ship.getFields()) {
                if (fieldOfShip == shot) {
                    ship.setNumberOfHints(ship.getNumberOfHints() + 1);
                    if (ship.getNumberOfHints() < ship.getSize()) {
                        return "trāpīts";
                    } else {
                        numberOfSunkenShip++;
                        if (numberOfSunkenShip == allShips.size()) {
                            return "visi kuģi nogremdēti";
                        }
                        return "grimst";
                    }
                }
            }
        }
        return "garām";
    }
}