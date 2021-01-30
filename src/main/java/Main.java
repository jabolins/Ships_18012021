import dbManegment.DbManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import playground.Playground;
import gameStatistic.GameStatistic;

import java.sql.SQLException;

public class Main extends Application {

    // izveidojam visus objektus kas būs vajadzīgi
    Playground ships = new Playground(10,1,1,1,1);
    GameStatistic gameStatistic = new GameStatistic();
    DbManagement dbManagement = new DbManagement();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load
                (Main.class.getResource("/FirstPage.fxml"));
        primaryStage.setTitle("kuģu kauja");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    } // sākums. Nodefinējam grafisko vidi

    public static void main(String[] args) {
        launch(args); // palaižam vizuālo logu

    } // palaižam grafisko vidi

    public boolean checkLogin(String name, String password) throws SQLException { // pārbauda vai tāds lietotājs reģistrēts
        return dbManagement.checkUser(name, password);
    } // pārbauda vai tāds lietotājs reģistrēts


    public void fixGameDate(int fieldSize, int ship4count, int ship3count, int ship2count, int ship1count) {
        gameStatistic.fixGameCode(fieldSize, ship4count, ship3count, ship2count, ship1count);
    } // piefiksē spēles sākumā laukuma izmēru, kuģu skaitu un
// ģenerē kodu ko vēlāk izmantosim ierakstam sql

}

