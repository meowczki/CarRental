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

public class AdminMenuController {
    @FXML
    private Button rentalsBtn;

    @FXML
    private Button batteryBtn;

    @FXML
    private Button earningsBtn;

    @FXML
    private Button returnBtn;

    @FXML
    void returnOnClick(ActionEvent event) throws IOException {
        newScene(returnBtn,"adminLoginFx.fxml");
    }
    @FXML
    void batteryBtnOnClick(ActionEvent event) throws IOException {
        newScene(batteryBtn,"batteryFX.fxml");
    }
    @FXML
    void earningsBtnOnClick(ActionEvent event) throws IOException {
        newScene(earningsBtn,"earningsFX.fxml");

    }

    @FXML
    void rentalsBtnOnClick(ActionEvent event) throws IOException {
        newScene(batteryBtn,"carRentalsFX.fxml");

    }
    private void newScene(Button loginBtn, String s) throws IOException {
        Stage stage;
        stage = (Stage) loginBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(s));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'adminMenuFx.fxml'.";
        assert rentalsBtn != null : "fx:id=\"rentalsBtn\" was not injected: check your FXML file 'adminMenuFx.fxml'.";
        assert batteryBtn != null : "fx:id=\"batteryBtn\" was not injected: check your FXML file 'adminMenuFx.fxml'.";
        assert earningsBtn != null : "fx:id=\"earningsBtn\" was not injected: check your FXML file 'adminMenuFx.fxml'.";

    }
}
