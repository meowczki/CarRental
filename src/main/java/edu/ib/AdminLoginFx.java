package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import edu.ib.dbClasses.AdminDao;
import edu.ib.dbClasses.ClientDao;
import edu.ib.dbClasses.DBUtilAdmin;
import edu.ib.dbClasses.DBUtilClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminLoginFx {

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
    private Button loginBtn;
    private DBUtilAdmin dbUtilAdmin;
    private static AdminDao adminDao;

    public static AdminDao getAdminDao() {
        return adminDao;
    }

    @FXML
    void loginBtnOnClick(ActionEvent event) {
        dbUtilAdmin =new DBUtilAdmin(emailTV.getText(),passwordTV.getText());
        try {
            dbUtilAdmin.dbConnect();
            newScene(loginBtn,"adminMenuFx.fxml");
            adminDao=new AdminDao(dbUtilAdmin);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void returnOnClick(ActionEvent event) throws IOException, SQLException {
        newScene(returnBtn, "startFX.fxml");
        if(dbUtilAdmin!=null)
        dbUtilAdmin.dbDisconnect();
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
    void initialize() {
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'adminLoginFx.fxml'.";
        assert emailTV != null : "fx:id=\"emailTV\" was not injected: check your FXML file 'adminLoginFx.fxml'.";
        assert passwordTV != null : "fx:id=\"passwordTV\" was not injected: check your FXML file 'adminLoginFx.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'adminLoginFx.fxml'.";

    }
}
