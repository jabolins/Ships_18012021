package interfaces;

public interface GameManagment {
    boolean createPlayground(int playgroundSize,
                             int numberOfSize1Ships,
                             int numberOfSize2ships,
                             int numberOfSize3ships,
                             int numberOfSize4ships);
    String checkShot(int shot);
}
