package controllers;


import gameStatistic.GameStatistic;
import interfaces.GameManagement;
import interfaces.StatisticManagment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import playground.Playground;

import java.io.IOException;
import java.util.ArrayList;


public class GamePageController {
    int numberOfSize4ships;
    int numberOfSize3ships;
    int numberOfSize2ships;
    int numberOfSize1ships;
    int playgroundSize;

    ArrayList<Button> allButtons = new ArrayList<>();
    StatisticManagment gameStatistic = new GameStatistic();

    @FXML
    private Button butHome;

    @FXML
    private GridPane gridLeaders;

    @FXML
    private Text txtInformation;

    @FXML
    private Button butStart;


    @FXML
    private Pane paneGamePane;

    @FXML
    private BorderPane borderPaneGamePane;

    @FXML
    private AnchorPane gameFieldBase;

    @FXML
    private Spinner<String> spinShipField;

    @FXML
    private Spinner<Integer> spinShip4;

    @FXML
    private Spinner<Integer> spinShip3;

    @FXML
    private Spinner<Integer> spinShip2;
    @FXML
    private Spinner<Integer> spinShip1;

    @FXML
    void initialize() {

        createAllSpinners();

        butHome.setOnAction(event -> {
            butHome.getScene().getWindow().hide();
            goToPage("/FirstPage.fxml");
        });

        butStart.setOnAction(event -> {
            getValuesFromSpinners();
            GameManagement playground = new Playground
                    (playgroundSize,
                            numberOfSize1ships,
                            numberOfSize2ships,
                            numberOfSize3ships,
                            numberOfSize4ships);

            if (!playground.createPlaygroundWithShips((Playground) playground)) {
                txtInformation.setText("šādi izvietot kuģus nav iespējams");
            } else {
                playground.printAllShips(); // tas pārbaudei
                createVisualField(playgroundSize, (Playground) playground); // vēl jālabo. Man neptīk kā ar interfeisiem sanāk
            }
        });
    }

    private void getValuesFromSpinners() {
        numberOfSize4ships = spinShip4.getValue();
        numberOfSize3ships = spinShip3.getValue();
        numberOfSize2ships = spinShip2.getValue();
        numberOfSize1ships = spinShip1.getValue();
        switch (spinShipField.getValue()) {
            case "11x11":
                playgroundSize = 11;
                break;
            case "12x12":
                playgroundSize = 12;
                break;
            case "13x13":
                playgroundSize = 13;
                break;
            case "14x14":
                playgroundSize = 14;
                break;
            case "15x15":
                playgroundSize = 15;
                break;
            case "16x16":
                playgroundSize = 16;
                break;
            case "17x17":
                playgroundSize = 16;
                break;
            case "18x18":
                playgroundSize = 16;
                break;
            case "19x19":
                playgroundSize = 16;
                break;
            case "20x20":
                playgroundSize = 16;
                break;
            default:
                playgroundSize = 10;
        }
    }

    private void createVisualField(int size, Playground playground) {
        allButtons.clear();// sākam visu no sākuma

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Button button = new Button();
                allButtons.add(button);
                button.setPrefSize(25, 20);
                button.setLayoutX(x * 27);
                button.setLayoutY(y * 27);
                button.setStyle("-fx-background-color: #0648F9");
                int buttName = y * 100 + x; // mainīgais pogai kas būs arī pogas vārds
                button.setId(String.valueOf(buttName));
                button.setOnAction(event -> {
                    pressButton(button, playground);
                });
                paneGamePane.getChildren().add(button);

            }
        }
    }

    private void pressButton(Button button, Playground playground) {
        int shot = Integer.parseInt(button.getId());
        if (gameStatistic.wasShotAlreadyBeen(shot)) {
            txtInformation.setText("šāds šāviens jau bija");
        } else {
            switch (playground.checkShot(shot)) {
                case "garām":{
                    txtInformation.setText("garām");
                    button.setStyle("-fx-background-color: #F9E706");
                    break;}
                case "trāpīts":{
                    txtInformation.setText("trāpīts");
                    button.setStyle("-fx-background-color: #FB2816");
                    break;}
                case "grimst": {
                    txtInformation.setText("grimst");
                    int[] fieldsOfSunkShip = (playground.findShipByFieldNr(shot));
                    ToColorButtonsSunkenShip(fieldsOfSunkShip);
                    break;}
                case "beigas": {
                    txtInformation.setText("jūs uzvarējāt. Veikti  tik un tik šāvieni"); // vēlāk jāsatais
                    int[] fieldsOfSunkShip = (playground.findShipByFieldNr(shot));
                    ToColorButtonsSunkenShip(fieldsOfSunkShip);
                    break;}
            }
            }
        }

    private void ToColorButtonsSunkenShip(int[] fieldsOfSunkShip) {
        for (int i = 0; i < fieldsOfSunkShip.length; i++) {
            for (Button checkButton : allButtons) {
                if (Integer.parseInt(checkButton.getId()) == fieldsOfSunkShip[i]) {
                    checkButton.setStyle("-fx-background-color: #050100");
                }
            }
        }
    }

    private void createAllSpinners() {
        SpinnerValueFactory<Integer> valueFactory1 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 4);// spinneru vērtību noteikšanai
        spinShip1.setValueFactory(valueFactory1);
        SpinnerValueFactory<Integer> valueFactory2 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 3);// spinneru vērtību noteikšanai
        spinShip2.setValueFactory(valueFactory2);
        SpinnerValueFactory<Integer> valueFactory3 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 2);// spinneru vērtību noteikšanai
        spinShip3.setValueFactory(valueFactory3);
        SpinnerValueFactory<Integer> valueFactory4 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);// spinneru vērtību noteikšanai
        spinShip4.setValueFactory(valueFactory4);

        ObservableList<String> fieldSizeValues = FXCollections.observableArrayList("10x10", "11x11",
                "12x12", "13x13", "14x14", "15x15", "16x16", "17x17", "18x18", "19x19", "20x20");

        SpinnerValueFactory<String> fieldSize = new SpinnerValueFactory.ListSpinnerValueFactory<String>(fieldSizeValues);
        fieldSize.setValue("10x10");// pamata vērtība
        spinShipField.setValueFactory(fieldSize);
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