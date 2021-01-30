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
    Playground ships = new Playground();
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

    public boolean createShips(int fieldSize, int ship4count, int ship3count, int ship2count, int ship1count) { // nodrošina visu kuģu izveidi izejot
        // no ievadītā laukuma izmēra, un kuģu skaita. Atgriež vērtību vai tas ir iespējams
        boolean result;
        result = ships.createAllShips(fieldSize, ship4count, ship3count, ship2count, ship1count);
        return result;
    } // tiek izveidoti visi kuģi un ja to var, atgriež vērtību true.

    public void fixGameDate(int fieldSize, int ship4count, int ship3count, int ship2count, int ship1count) {
        gameStatistic.fixGameCode(fieldSize, ship4count, ship3count, ship2count, ship1count);
    } // piefiksē spēles sākumā laukuma izmēru, kuģu skaitu un
// ģenerē kodu ko vēlāk izmantosim ierakstam sql

}

