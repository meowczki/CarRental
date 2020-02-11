package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import edu.ib.dbClasses.ClientDao;
import edu.ib.views.CarRented;
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

public class ReturnCarController {

    public ComboBox<CarRented> rentsCombo;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField latTV;

    @FXML
    private TextField lonTV;

    @FXML
    private Button returnCarBtn;
    ObservableList<CarRented> rents;
    @FXML
    private Button returnBtn;
    ClientDao clientDao;

    @FXML
    void returnCarOnClick(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        clientDao.updateCarRental(dateFormat.format(date),Double.valueOf(latTV.getText()),Double.valueOf(lonTV.getText()),rentsCombo.getValue().getId_car_rentals());
        rents = clientDao.showAllRents();
        rentsCombo.setItems(rents);
        newScene();
    }

    @FXML
    void returnOnClick(ActionEvent event) throws IOException {
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
    void initialize() {
        assert latTV != null : "fx:id=\"latTV\" was not injected: check your FXML file 'returnCar.fxml'.";
        assert lonTV != null : "fx:id=\"lonTV\" was not injected: check your FXML file 'returnCar.fxml'.";
        assert returnCarBtn != null : "fx:id=\"returnCarBtn\" was not injected: check your FXML file 'returnCar.fxml'.";
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'returnCar.fxml'.";

        try {
            clientDao = ClientLoginFx.getClientDao();
            rents = clientDao.showAllRents();
            rentsCombo.setItems(rents);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

