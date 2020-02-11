package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import edu.ib.dbClasses.AdminDao;
import edu.ib.views.CarAdmin;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class BatteryController {

    @FXML
    private ListView<CarAdmin> carList;

    @FXML
    private Button returnBtn;

    @FXML
    private Button chargeBtn;
    private AdminDao adminDao;
    ObservableList<CarAdmin> cars;

    private void newScene()  {
        Stage stage;
        Parent root = null;
        stage = (Stage) returnBtn.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource("adminMenuFx.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void chargeBtnOnClick(ActionEvent event) {
        try {
            adminDao.chargeCar( carList.getSelectionModel().getSelectedItem().getId_car());
            cars = adminDao.showAvailableCars();
            carList.getItems().clear();
            carList.getItems().addAll(cars);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void returnBtnOnClick(ActionEvent event) {
newScene();
    }

    @FXML
    void initialize() {
        assert carList != null : "fx:id=\"carList\" was not injected: check your FXML file 'batteryFX.fxml'.";
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'batteryFX.fxml'.";
        assert chargeBtn != null : "fx:id=\"chargeBtn\" was not injected: check your FXML file 'batteryFX.fxml'.";
        try {
            adminDao = AdminLoginFx.getAdminDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cars = adminDao.showAvailableCars();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        carList.getItems().addAll(cars);
    }
}
