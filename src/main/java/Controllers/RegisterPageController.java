package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterPageController {



    @FXML
    private Button butHome;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword1;

    @FXML
    private PasswordField txtPassword2;

    @FXML
    private Button butReg;

    @FXML
    void initialize() {

        butHome.setOnAction(event -> {
            butHome.getScene().getWindow().hide();
            goToPage("/FirstPage.fxml");
        });
    }

    private void goToPage(String page) {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource(page));
        try {
            load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent run = load.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(run));
        stage.show();
    }


}
