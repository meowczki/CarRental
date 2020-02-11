package edu.ib;

import java.io.IOException;
import java.sql.SQLException;

import edu.ib.dbClasses.DBUtilClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterFX {


    @FXML
    private Button returnBtn;

    @FXML
    private TextField emailTV;

    @FXML
    private TextField passwordTV;
    @FXML
    private TextField nameTV;

    @FXML
    private Button registerBtn;

    @FXML
    private TextField repeatPasswordTV;

    @FXML
    void registerOnClick(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
      boolean registerSuccesful=false;
      DBUtilClient dbUtilClient=new DBUtilClient();
      dbUtilClient.dbConnect();
        StringBuilder sb=new StringBuilder("insert into clients(client_name,email,password) values('");

        if(passwordTV.getText().equals(repeatPasswordTV.getText())){
          sb.append(nameTV.getText());
          sb.append("','");
          sb.append(emailTV.getText());
          sb.append("','");
          sb.append(passwordTV.getText());
          sb.append("');");
            String query=sb.toString();
            dbUtilClient.dbExecuteUpdate(query);
            registerSuccesful=true;
      }

        Stage stage;
        Parent root;
        if(registerSuccesful) {
            stage = (Stage) returnBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("clientLoginFx.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void returnOnClick(ActionEvent event) throws IOException {
        newScene();
    }

    private void newScene() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) returnBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("clientLoginFx.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'registerFX.fxml'.";
        assert emailTV != null : "fx:id=\"emailTV\" was not injected: check your FXML file 'registerFX.fxml'.";
        assert passwordTV != null : "fx:id=\"passwordTV\" was not injected: check your FXML file 'registerFX.fxml'.";
        assert registerBtn != null : "fx:id=\"registerBtn\" was not injected: check your FXML file 'registerFX.fxml'.";
        assert repeatPasswordTV != null : "fx:id=\"repeatPasswordTV\" was not injected: check your FXML file 'registerFX.fxml'.";
        assert nameTV != null : "fx:id=\"nameTV\" was not injected: check your FXML file 'registerFX.fxml'.";

    }
}
