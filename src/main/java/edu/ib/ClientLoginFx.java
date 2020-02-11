package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import edu.ib.dbClasses.ClientDao;
import edu.ib.dbClasses.DBUtilClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientLoginFx {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnBtn;

    @FXML
    private TextField emailTV;

    @FXML
    private TextField passwordTV;

    @FXML
    private Button registerBtn;

    @FXML
    private Button loginBtn;

private DBUtilClient dbUtilClient;
private static ClientDao clientDao;

    public static ClientDao getClientDao() {
        return clientDao;
    }

    @FXML
    void loginBtnOnClick(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        dbUtilClient=new DBUtilClient();
        dbUtilClient.dbConnect();
        StringBuilder sb=new StringBuilder("select * from clients where email='");
        sb.append(emailTV.getText());
        sb.append("' and password='");
        sb.append(passwordTV.getText());
        sb.append("';");
        ResultSet resultSet= dbUtilClient.dbExecuteQuery(sb.toString());

        if(resultSet.next()){

            clientDao=new ClientDao(dbUtilClient);
           int id= clientDao.getClientId(emailTV.getText().toString());
            clientDao.setIdClient(id);
            newScene(loginBtn, "clientMenu.fxml");

        }


    }

    private void newScene(Button loginBtn, String s) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) loginBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(s));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void registerOnClick(ActionEvent event) throws IOException, SQLException {
        if(dbUtilClient!=null)
            dbUtilClient.dbDisconnect();
        newScene(registerBtn, "registerFX.fxml");
    }

    @FXML
    void returnOnClick(ActionEvent event) throws IOException, SQLException {
        newScene(returnBtn, "startFX.fxml");
        if(dbUtilClient!=null)
            dbUtilClient.dbDisconnect();
    }

    @FXML
    void initialize() {
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'clientLoginFx.fxml'.";
        assert emailTV != null : "fx:id=\"emailTV\" was not injected: check your FXML file 'clientLoginFx.fxml'.";
        assert passwordTV != null : "fx:id=\"passwordTV\" was not injected: check your FXML file 'clientLoginFx.fxml'.";
        assert registerBtn != null : "fx:id=\"registerBtn\" was not injected: check your FXML file 'clientLoginFx.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'clientLoginFx.fxml'.";

    }
}
