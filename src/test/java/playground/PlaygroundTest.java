package playground;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class PlaygroundTest {

    @Test
    public void createPlaygroundWithShips() {

    }

    @Test
    public void createArrayAllShips() {
        int playgroundSize= 10;
        int numberOfSize1Ship=2;
        int numberOfSize2Ship=2;
        int numberOfSize3Ship=2;
        int numberOfSize4Ship=1;


        Playground playground = new Playground(playgroundSize,
                numberOfSize1Ship,
                numberOfSize2Ship,
                numberOfSize3Ship,
                numberOfSize4Ship);

        playground.createArrayAllShips(numberOfSize4Ship,numberOfSize3Ship,numberOfSize2Ship,numberOfSize1Ship);
        assertTrue(playground.getAllShips().size()==numberOfSize1Ship+
                numberOfSize2Ship+
                numberOfSize3Ship+
                numberOfSize4Ship);
    }

    @Test
    public void createShips() {
    }

    @Test
    public void checkOccupiedFields() {
    }

    @Test
    public void checkShot() {
    }
}