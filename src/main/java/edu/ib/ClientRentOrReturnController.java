package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ClientRentOrReturnController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button rentBtn;

    @FXML
    private Button returnCarBtn;

    @FXML
    private Button returnBtn;
    @FXML
    void rentOnClick(ActionEvent event) throws IOException {
        newScene(rentBtn, "rentCarFX.fxml");
    }

    @FXML
    void returnBtnOnClick(ActionEvent event) throws IOException {
        newScene(returnBtn, "clientLoginFx.fxml");
    }

    private void newScene(Button returnBtn, String s) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) returnBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(s));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void returnCarBtnOnClick(ActionEvent event) throws IOException {
        newScene(returnBtn, "returnCar.fxml");
    }

    @FXML
    void initialize() {
        assert rentBtn != null : "fx:id=\"rentBtn\" was not injected: check your FXML file 'clientMenu.fxml'.";
        assert returnCarBtn != null : "fx:id=\"returnCarBtn\" was not injected: check your FXML file 'clientMenu.fxml'.";
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'clientMenu.fxml'.";

    }
}
