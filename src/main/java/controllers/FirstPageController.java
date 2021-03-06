package controllers;


import dbManegment.DatabaseUser;
import interfaces.DatabaseUserManagment;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


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
           try {
                if (checkLogin()) { // pārbaudām vai šāds lietotājs un parole ir reģistrēti

                    //setGamer(txtName.getText()); // piefiksējam spēlētāju kas ir ielogojies. Pagaidām neaktīvs
                    butLogin.getScene().getWindow().hide();
                    goToPage("/GamePage.fxml");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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

    private boolean checkLogin() throws SQLException {
        DatabaseUserManagment databaseUser= new DatabaseUser();
        String user = txtName.getText().trim();
        String password = txtPass.getText().trim();
        if (!user.equals("") && !password.equals("")) { // pārbaudām vai ir aizpildīti abi lauki te man šķiet jābūt OR nevis AND jāpārbaude

            if (databaseUser.checkUserLogin(user, password)) {
                return true;
            } else {
                System.out.println("nepareiza parole vai lietotājs");// šis jāpapildina ar lauku robežu iekrāsošanu un izlecošo logu
                return false;
            }

        } else { // ja kāds no laukiem nav aizpildīts
            System.out.println("ierakstiet vārdu un paroli");// šis jāpapildina ar lauku robežu nokrāsošanu sarkanu un izlecošo logu
        }
        return false;
    }

}

