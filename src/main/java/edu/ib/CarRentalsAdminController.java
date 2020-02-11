package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import edu.ib.dbClasses.AdminDao;
import edu.ib.views.CarAdmin;
import edu.ib.views.CarRental;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CarRentalsAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnBtn;

    @FXML
    private ListView<CarRental> rentalList;

    @FXML
    private Button showBtn;

    @FXML
    private ComboBox<CarAdmin> carsCombo;
    private AdminDao adminDao;
    ObservableList<CarAdmin> cars;
    @FXML
    void returnOnClick(ActionEvent event) {
        newScene();

    }
    private void newScene()   {
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
    void showOnClick(ActionEvent event) {
        try {
            rentalList.getItems().addAll(adminDao.showRentalsWhereCarID(carsCombo.getValue().getId_car()));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'carRentalsFX.fxml'.";
        assert rentalList != null : "fx:id=\"rentalList\" was not injected: check your FXML file 'carRentalsFX.fxml'.";
        assert showBtn != null : "fx:id=\"showBtn\" was not injected: check your FXML file 'carRentalsFX.fxml'.";
        assert carsCombo != null : "fx:id=\"carsCombo\" was not injected: check your FXML file 'carRentalsFX.fxml'.";
        try {
            adminDao = AdminLoginFx.getAdminDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cars = adminDao.showAllCars();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        carsCombo.setItems(cars);
    }
}
