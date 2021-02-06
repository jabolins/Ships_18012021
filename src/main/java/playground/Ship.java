package playground;

public class Ship {

    private int size;
    private int[] fields;
    private int[] fieldsAroundShip;
    private int numberOfHints;

    public int getSize() {
        return size;
    }

    public int[] getFields() {
        return fields;
    }

    public int[] getFieldsAroundShip() {
        return fieldsAroundShip;
    }

    public int getNumberOfHints() {
        return numberOfHints;
    }

    public void setNumberOfHints(int numberOfHints) {
        this.numberOfHints = numberOfHints;
    }

    Ship(int size) {
        this.size = size;
        numberOfHints = 0;
        fields = new int[size];
        fieldsAroundShip = new int[(size + 2) * 3];
    }

    public void deployShip(Ship ship, int sizeOfPlayground) {
        String directionOfShip = directionOfShip();
        int startPositionOfShip= startPositionOfShip(directionOfShip, sizeOfPlayground, size);
        registerShipFields(ship, directionOfShip, startPositionOfShip);
        registerFieldsAroundShip(ship, directionOfShip);
    }

    private void registerShipFields(Ship ship, String directionOfShip, int startPositionOfShip) {
        if (directionOfShip.equals("horizontal")) {
            for (int i = 0; i < ship.size; i++) {
                ship.fields[i] = startPositionOfShip + i;
            }
        } else {
            for (int i = 0; i < ship.size; i++) {
                ship.fields[i] = startPositionOfShip + i * 100;
            }
        }
    }

    public int startPositionOfShip(String directionOfShip, int sizeOfPlayground, int size) {
        int startPositionOfShip;
        int startPointVertical;
        int startPointHorizontal;
        if (directionOfShip.equals("horizontal")) {
            startPointHorizontal = (int) (Math.random() * (sizeOfPlayground - size));
            startPointVertical = (int) (Math.random() * sizeOfPlayground);
        } else {
            startPointHorizontal = (int) (Math.random() * (sizeOfPlayground));
            startPointVertical = (int) (Math.random() * (sizeOfPlayground - size));
        }
        startPositionOfShip = startPointHorizontal + startPointVertical * 100;
        return startPositionOfShip;
    }

    private void registerFieldsAroundShip(Ship ship, String directionOfShip) {
        int startPointAroundField = ship.fields[0] - 100 - 1;
        int nrOfFieldAround = 0;
        if (directionOfShip.equals("horizontal")) {
            for (int horizontal = 0; horizontal < ship.size + 2; horizontal++) {
                for (int vertical = 0; vertical < 3; vertical++) {
                    ship.fieldsAroundShip[nrOfFieldAround] = startPointAroundField + horizontal + vertical * 100;
                    nrOfFieldAround++;
                }
            }
        } else {
            for (int vertical = 0; vertical < ship.size + 2; vertical++) {
                for (int horizontal = 0; horizontal < 3; horizontal++) {
                    ship.fieldsAroundShip[nrOfFieldAround] = startPointAroundField + horizontal + vertical * 100;
                    nrOfFieldAround++;
                }
            }
        }
    }

    public String directionOfShip() {
        if ((int) (Math.random() * 2 + 1) % 2 == 0) {
            return "horizontal";
        } else {
            return "vertical";
        }
    }


}
