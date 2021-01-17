package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPageController {

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Button butLogin;

    @FXML
    private Button butReg;

    @FXML
    void initialize() {

        butLogin.setOnAction(event -> {

            checkLogin();
            butLogin.getScene().getWindow().hide();
            goToPage("/GamePage.fxml");
        });

        butReg.setOnAction(event -> {
            butReg.getScene().getWindow().hide();
            goToPage("/RegisterPage.fxml");
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

    private boolean checkLogin() {
        return false;
    }
}
