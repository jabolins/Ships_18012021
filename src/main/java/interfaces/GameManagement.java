package interfaces;

import playground.Playground;

public interface GameManagement {
    boolean createPlaygroundWithShips(Playground playground);
    String checkShot(int shot);
    void printAllShips();  // šis ir testam, vēlāk jāizdzēš
    int[] findShipByFieldNr(int fieldNr);
}
