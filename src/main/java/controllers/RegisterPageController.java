package controllers;

import java.io.IOException;
import java.sql.SQLException;

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
    private Button butStart;

    @FXML
    void initialize() {

        butHome.setOnAction(event -> {
            butHome.getScene().getWindow().hide();
            goToPage("/FirstPage.fxml");
        }); // nospiežot pogu Home atgriežas sākuma lapā

        butReg.setOnAction(event -> {
            if (checkFields()) { // ja lauki aizpildīti korekti
                try {
                    if (!checkUsername()) { // ja datu bāzē neatrod tādu lietotāju tad sākam reģistrāciju

                        String name = txtName.getText().trim();
                        String password = txtPassword1.getText().trim();
                        String eMail = txtEmail.getText().trim();
                        DatabaseUserManagment databaseUser = new DatabaseUser();
                        databaseUser.userRegistration(name, password, eMail); // tā bija metode lietotāja reģistrēšanai datu bāzē
                        System.out.println("lietotājs reģistrēts veiksmīgi."); // šeit jāpapildina ar pogas "sākt spēli" aktivizēšanu
                        butStart.setDisable(false); // aktivizējam pogu Start
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }); // nospiežot pogu reģistrēties pārbauda visus datus. Ja viss OK,
        // reģistrē jaunu lietotāju, aktivizē pogu Start

        butStart.setOnAction(event -> {
            butStart.getScene().getWindow().hide();
            goToPage("/GamePage.fxml");
        });
        // nospiežot pogu Start aiziet uz GamePage

    }

    private boolean checkFields() {
        String name = txtName.getText().trim();
        String password1 = txtPassword1.getText().trim();
        String password2 = txtPassword2.getText().trim();
        String eMail = txtEmail.getText().trim();
        if (!name.equals("") && !password1.equals("") && !password2.equals("") && !eMail.equals("")) { // pārbaudām vai visi lauki ir aizpildīti
            if (password1.equals(password2)) {
                return true;
            } else {
                System.out.println("paroles nesakrīt");// šis jāpapildina ar robežu krāsu nomaiņu un izlecošo logu
                return false;
            }
        } else { // ja kāds no laukiem nav aizpildīts
            System.out.println("aizpildiet visus laukus"); // šis jāpapildina ar robežu krāsu nomaiņu un izlecošo logu
            return false;
        }
    } // pārbauda vai korekti aizpildīti lauki. Nepārbauda ierakstus datu bāzē, tas vēlāk

    private boolean checkUsername() throws SQLException {
        String username = txtName.getText().trim();
        DatabaseUserManagment databaseUser = new DatabaseUser();
        if (databaseUser.isUsernameUnique(username)) { // ja atrod sakritību datu bāzē tad....
            System.out.println("šāds lietotājs jau reģistrēts"); // šis jāpapildina ar robežu iekrāsošanu un izlecošo logu
            return true;
        }
        return false;
    } // pārbauda vai tāds vārds jau nav reģistrēts


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
    } // iet uz norādito lapu


}
