package edu.ib;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.ib.dbClasses.ClientDao;
import edu.ib.views.CarClient;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RentCarController {


    @FXML
    private TextField latTV;

    @FXML
    private TextField lonTV;

    @FXML
    private Button rentBtn;

    @FXML
    private Button returnBtn;
    @FXML
    private ComboBox<CarClient> carsCombo;
    private ClientDao clientDao;
    ObservableList<CarClient> cars;

    @FXML
    void rentOnClick(ActionEvent event) throws ClassNotFoundException, SQLException {


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        try {
            clientDao.insertCarRental(carsCombo.getValue().getId_car(), Double.valueOf(latTV.getText()), Double.valueOf(lonTV.getText()), dateFormat.format(date));
            newScene();
            cars = clientDao.showAllCars();
            carsCombo.setItems(cars);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void returnBtnOnClick(ActionEvent event) throws IOException {
        newScene();
    }

    private void newScene() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) returnBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("clientMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        assert latTV != null : "fx:id=\"latTV\" was not injected: check your FXML file 'rentCarFX.fxml'.";
        assert lonTV != null : "fx:id=\"lonTV\" was not injected: check your FXML file 'rentCarFX.fxml'.";
        assert rentBtn != null : "fx:id=\"rentBtn\" was not injected: check your FXML file 'rentCarFX.fxml'.";
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'rentCarFX.fxml'.";
        assert carsCombo != null : "fx:id=\"carsCombo\" was not injected: check your FXML file 'rentCarFX.fxml'.";
        try {
            clientDao = ClientLoginFx.getClientDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
        cars = clientDao.showAllCars();
        carsCombo.setItems(cars);
    }
}
