package controllers;

import interfaces.GameManagement;
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
import javafx.scene.layout.GridPane;
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

    @FXML
    private Button butHome;

    @FXML
    private GridPane gridLeaders;

    @FXML
    private Text txtInformation;

    @FXML
    private Button butStart;

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

            if (!playground.createPlaygroundWithShips((Playground) playground)){
                txtInformation.setText("šādi izvietot kuģus nav iespējams");
            } else {
                System.out.println(playgroundSize); // tas pārbaudei
                playground.printAllShips(); // tas pārbaudei
               createVisualField(playgroundSize);// vēl jālabo
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


    private void createVisualField(int size) {
        allButtons.clear();// sākam visu no sākuma
        GridPane gameField = new GridPane();
        gameField.relocate(0, 0);
        gameField.setHgap(2);
        gameField.setVgap(2);
        gameFieldBase.getChildren().add(gameField);

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Button button = new Button();
                allButtons.add(button);
                button.setPrefSize(250 / size, 100 / size); // veidojam dinamiskus lauciņu izmērus. varbūt vēlāk atteiksimies bet pagaidām lai ir
                button.setStyle("-fx-background-color: #0648F9");
                int buttName = y * 100 + x; // mainīgais pogai kas būs arī pogas vārds
                button.setId(String.valueOf(buttName));
                button.setOnAction(event -> {
                    pressButton(button);
                });
                gameField.add(button, x, y);
            }
        }
    } // izveidojam atbilstoša izmēra laukumu, saliekam uz tā "pogas/lauciņus"

    private void pressButton(Button button) {// te aprakstīts kas notiks kad nospiedīs "kuģu lauciņu"
//        int ShipNr; // būs vajadzīgs vēlāk meklējot konkrēto kuģi pie case "beigas" un case "grimst"
//
//        if (GameStatistic.newShotStatisticCheck((Integer.parseInt(button.getId()))) == false) {// ja tāds šāviens jau bija, neko nedarām
//            txtInformation.setText("šāds šāviens jau bija");
//        } else {// ja šāds šāviens nav bijis
//            switch (Playground.shotTest(Integer.parseInt(button.getId()))) { // pārbaudām "šāviena"rezultātu
//                case "garām":
//                    txtInformation.setText("garām");
//                    button.setStyle("-fx-background-color: #F9E706");
//                    break;
//                case "trāpīts":
//                    txtInformation.setText("trāpīts");
//                    button.setStyle("-fx-background-color: #FB2816");
//                    break;
//                case "beigas":
//                    txtInformation.setText("jūs uzvarējāt. Veikti " + GameStatistic.getAllShots().size() + " šāvieni");
//                    ShipNr = Playground.findShip(Integer.parseInt(button.getId())); // dabūjam nogrimušā kuģa kārtas NR masīvā
//                    for (int buttNr = 0; buttNr < allButtons.size(); buttNr++) { // nokrāsojam visas pogas kas "piederēja" šim kuģim
//                        for (int shipAreaNr = 0; shipAreaNr < Playground.getAllShips().get(ShipNr).getShipSize(); shipAreaNr++) {
//                            if (Playground.getAllShips().get(ShipNr).getShipFields()[shipAreaNr] == Integer.parseInt(allButtons.get(buttNr).getId())) {// ja sašautā kuģa lauciņš sakrīt ar pogas nosaukumu
//                                allButtons.get(buttNr).setStyle("-fx-background-color: #050100");
//                            }
//                        }
//                    }
//                    System.out.println("spēlētājs bija" + GameStatistic.getGamer() + " spēles kods bija" + GameStatistic.getGameCode()); // šis ir pārbaudei. vēlāk jāizdzēš
//                    break;
//                case "grimst": {
//                    txtInformation.setText("grimst");
//                    System.out.println("grimst");
//                    ShipNr = Playground.findShip(Integer.parseInt(button.getId()));// dabūjam nogrimušā kuģa kārtas NR masīvā
//                    for (int buttNr = 0; buttNr < allButtons.size(); buttNr++) {// nokrāsojam visas pogas kas "piederēja" šim kuģim
//                        for (int shipAreaNr = 0; shipAreaNr < Playground.getAllShips().get(ShipNr).getShipSize(); shipAreaNr++) {
//                            if (Playground.getAllShips().get(ShipNr).getShipFields()[shipAreaNr] == Integer.parseInt(allButtons.get(buttNr).getId())) {// ja sašautā kuģa lauciņš sakrīt ar pogas nosaukumu
//                                allButtons.get(buttNr).setStyle("-fx-background-color: #050100");
//                            }
//                        }
//                    }
//                }
//                registerGameResult(); // aizpildām datus par spēles rezultātu
//                break;
//            }
//        }
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
    } // saliek visas vērtības izvēles logiem

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

    private void registerGameResult() {

    }

}