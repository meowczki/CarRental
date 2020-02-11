package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import edu.ib.dbClasses.AdminDao;
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

public class EarningsController {


    @FXML
    private ComboBox<String> datesCombo;

    @FXML
    private Button showBtn;

    @FXML
    private TextField earningsTV;

    @FXML
    private Button returnBtn;
private AdminDao adminDao;
    ObservableList<String> dates;

    @FXML
    void returnBtnOnClick(ActionEvent event) throws IOException {
        newScene();
    }

    private void newScene() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) returnBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("adminMenuFx.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void showOnClick(ActionEvent event) {
        try {
            earningsTV.setText(String.valueOf(adminDao.getEarningsFromDay(datesCombo.getValue())));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        assert datesCombo != null : "fx:id=\"datesCombo\" was not injected: check your FXML file 'earningsFX.fxml'.";
        assert showBtn != null : "fx:id=\"showBtn\" was not injected: check your FXML file 'earningsFX.fxml'.";
        assert earningsTV != null : "fx:id=\"earningsTV\" was not injected: check your FXML file 'earningsFX.fxml'.";
        assert returnBtn != null : "fx:id=\"returnBtn\" was not injected: check your FXML file 'earningsFX.fxml'.";
        try {
            adminDao = AdminLoginFx.getAdminDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dates = adminDao.showAllDates();

        datesCombo.setItems(dates);    }
}
