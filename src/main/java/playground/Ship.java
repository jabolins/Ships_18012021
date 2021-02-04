package playground;

public class Ship {
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

    private int size;
    private int[] fields;
    private int[] fieldsAroundShip;
    private int numberOfHints;

    Ship(int size) {
        this.size = size;
        numberOfHints = 0;
        fields = new int[size];
        fieldsAroundShip = new int[(size + 2) * 3];
    }

    public void deployShip(Ship ship, int sizeOfPlayground) {
        String directionOfShip = directionOfShip();
        if (directionOfShip.equals("horizontal")) {

            int startPointHorizontal = (int) (Math.random() * (sizeOfPlayground - size));
            int startPointVertical = (int) (Math.random() * sizeOfPlayground);
            int startPositionOfShip = startPointHorizontal + startPointVertical * 100;

            for (int i = 0; i < ship.size; i++) {
                ship.fields[i] = startPositionOfShip + i;
            }
        } else {

            int startPointHorizontal = (int) (Math.random() * (sizeOfPlayground));
            int startPointVertical = (int) (Math.random() * (sizeOfPlayground - size));
            int startPositionOfShip = startPointHorizontal + startPointVertical * 100;

            for (int i = 0; i < ship.size; i++) {
                ship.fields[i] = startPositionOfShip + i * 100;
            }
        }
        registerFieldsAroundShip(ship, directionOfShip);
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

    private String directionOfShip() {
        if ((int) (Math.random() * 2 + 1) % 2 == 0) {
            return "horizontal";
        } else {
            return "vertical";
        }
    }


}
