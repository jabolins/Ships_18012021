package playground;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShipTest {

    @Test
    public void areBothDirectionForShipBeingFormed() {

        int horizontalCount = 0;
        int verticalCount = 0;
        int incorectOutputFromMethod = 0;

        Ship ship = new Ship(3);
        for (int i = 0; i < 10; i++) {
            String result = ship.directionOfShip();
            if (result == "horizontal") {
                horizontalCount++;
            } else if (result == "vertical") {
                verticalCount++;
            } else {
                incorectOutputFromMethod++;
            }
        }
        assertTrue(horizontalCount > 0
                && verticalCount > 0
                && incorectOutputFromMethod == 0);
    }

    @Test
    public void shouldHorizontalShipFieldsNotOutOfPlaygraund() {
        int sizeOfPlayground = 10;
        Ship ship = new Ship(4);
        int endPositionOfShip = 0;

            endPositionOfShip = (ship.startPositionOfShip("horizontal", sizeOfPlayground, ship.getSize())) + ship.getSize();
        assertTrue(endPositionOfShip %100 <= sizeOfPlayground && endPositionOfShip>0);
    }
    @Test
    public void shouldVerticalShipFieldsNotOutOfPlaygraund() {
        int sizeOfPlayground = 10;
        int sizeOFShip=4;
        Ship ship = new Ship(sizeOFShip);
        int endPositionOfShip = 0;

            endPositionOfShip = (ship.startPositionOfShip("vertical", sizeOfPlayground, ship.getSize())) + ship.getSize();

        assertTrue(endPositionOfShip <= sizeOfPlayground*100 && endPositionOfShip>0);
    }
    @Test
    public void shuldDeploySHipCreateCorrectLenghtOfList(){

        int sizeOfShip=3;
        Ship ship = new Ship(sizeOfShip);
        int sizeOfPlayground=10;
        ship.deployShip(ship, sizeOfPlayground);
        assertTrue(ship.getFields().length== sizeOfShip);

    }
    @Test
    public void shouldDeployShipCreatedListIsNotNull(){
        int sizeOfShip= 2;
        int sizeOfPlayground= 10;
        Ship ship = new Ship(sizeOfShip);
        ship.deployShip(ship, sizeOfPlayground);
        assertTrue(ship.getFields()[0]+ship.getFields()[1]>0);

    }
    @Test
    public void shuldregisterFieldsAroundShipCreateCorrectLenghtOfList(){

        int sizeOfShip=3;
        Ship ship = new Ship(sizeOfShip);
        int sizeOfPlayground=10;
        ship.deployShip(ship, sizeOfPlayground);
        assertTrue(ship.getFieldsAroundShip().length== (sizeOfShip+2)*3);

    }

    @Test
    public void shuldregisterFieldsAroundShipCreatedListIsNotNull(){
        int sizeOfShip= 2;
        int sizeOfPlayground= 10;
        Ship ship = new Ship(sizeOfShip);
        ship.deployShip(ship, sizeOfPlayground);
        assertTrue(ship.getFieldsAroundShip()[0]!=0 || ship.getFieldsAroundShip()[1]!=0);
    }

}