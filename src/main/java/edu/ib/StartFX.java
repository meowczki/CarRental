package edu.ib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class StartFX {


    @FXML
    private Button clientBtn;

    @FXML
    private Button administratorBtn;

    @FXML
    void admBtnOnClick(ActionEvent event) throws IOException {
        newScene("adminLoginFx.fxml");
    }

    private void newScene(String s) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) clientBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(s));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clientBtnOnClick(ActionEvent event) throws IOException {
        newScene("clientLoginFx.fxml");
    }

    @FXML
    void initialize() {
        assert clientBtn != null : "fx:id=\"clientBtn\" was not injected: check your FXML file 'startFX.fxml'.";
        assert administratorBtn != null : "fx:id=\"administratorBtn\" was not injected: check your FXML file 'startFX.fxml'.";

    }
}
