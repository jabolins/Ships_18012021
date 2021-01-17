package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GamePageController {

    @FXML
    private Button butHome;

    @FXML
    private GridPane gridLeaders;

    @FXML
    private Text txtInformation;

    @FXML
    private Button butStart;

    @FXML
    private AnchorPane gameField;

    @FXML
    void initialize() {

        butHome.setOnAction(event -> {
            butHome.getScene().getWindow().hide();
            goToPage("/FirstPage.fxml");
        });

    }

    private void goToPage(String page) {
        FXMLLoader load= new FXMLLoader();
        load.setLocation(getClass().getResource(page));
        try {
            load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent run =load.getRoot();
        Stage stage= new Stage();
        stage.setScene(new Scene(run));
        stage.show();
    }
}