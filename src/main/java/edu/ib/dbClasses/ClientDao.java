package edu.ib.dbClasses;

import edu.ib.views.CarClient;
import edu.ib.views.CarRented;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao {
    private DBUtilClient dbUtil;
    private int idClient;

    public ClientDao(DBUtilClient dbUtil, int idClient) {
        this.dbUtil = dbUtil;
        this.idClient = idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public ClientDao(DBUtilClient dbUtil) {
        this.dbUtil = dbUtil;
    }

    public int getClientId(String email) throws SQLException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder("select id_client from clients where email='");
        sb.append(email);
        sb.append("';");
        String selectStmt = sb.toString();
        int id = 0;
        try {
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            while (resultSet.next()) {
                id = resultSet.getInt("id_client");

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
        return id;
    }

    public ObservableList<CarRented> showAllRents() throws SQLException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder("SELECT * FROM car_rentals WHERE id_client =");
        sb.append(idClient);
        sb.append(" and geocoor_return_lat is null");
        sb.append(";");
        String selectStmt = sb.toString();
        System.out.println(selectStmt);
        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<CarRented> carsRentedList = getCarsRented(resultSet);


            return carsRentedList;


        } catch (SQLException e) {
            throw e;
        }

    }

    public ObservableList<CarClient> showAllCars() throws SQLException, ClassNotFoundException {

        String selectStmt = "select * from carsToRent";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<CarClient> carsRentedList = getCarsToRent(resultSet);
            return carsRentedList;

        } catch (SQLException e) {
            throw e;
        }
    }

    private ObservableList<CarRented> getCarsRented(ResultSet rs) throws SQLException {

        ObservableList<CarRented> carsRented = FXCollections.observableArrayList();

        while (rs.next()) {

            CarRented carRented = new CarRented(rs.getInt("id_car_rentals"), rs.getInt("id_car"), rs.getDouble("geocoor_rent_lat"), rs.getDouble("geocoor_rent_lon"), rs.getDouble("geocoor_return_lat"), rs.getDouble("geocoor_return_lon"), rs.getString("date_rent"), rs.getString("date_return"));

            carsRented.add(carRented);
        }

        return carsRented;
    }

    private ObservableList<CarClient> getCarsToRent(ResultSet rs) throws SQLException {

        ObservableList<CarClient> carsToRent = FXCollections.observableArrayList();

        while (rs.next()) {

            CarClient carClient = new CarClient(rs.getInt("id_car"), rs.getString("car_name"), rs.getString("brand"), rs.getDouble("rate"));
            carsToRent.add(carClient);
        }

        return carsToRent;
    }

    public void insertCarRental(int idCar, double geocoor_rent_lat, double geocoor_rent_lon, String date_rent) throws SQLException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder("INSERT INTO car_rentals(id_car,id_client,geocoor_rent_lat,geocoor_rent_lon,date_rent) VALUES('");
        sb.append(idCar);
        sb.append("','");
        sb.append(idClient);
        sb.append("','");
        sb.append(geocoor_rent_lat);
        sb.append("','");
        sb.append(geocoor_rent_lon);
        sb.append("','");
        sb.append(date_rent);
        sb.append("');");
        String insertStmt = sb.toString();

        try {

            dbUtil.dbExecuteUpdate(insertStmt);

        } catch (SQLException e) {
            throw e;
        }

    }

    public void updateCarRental(String date_return, double geocoor_return_lat, double geocoor_return_lon, int id_car_rentals) throws SQLException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder("UPDATE car_rentals SET date_return ='");
        sb.append(date_return);
        sb.append("',");
        sb.append("geocoor_return_lat=");
        sb.append(geocoor_return_lat);
        sb.append(",");
        sb.append("geocoor_return_lon=");
        sb.append(geocoor_return_lon);
        sb.append(" where id_car_rentals=");
        sb.append(id_car_rentals);
        sb.append(";");
        String insertStmt = sb.toString();
        System.out.println(insertStmt);
        try {

            dbUtil.dbExecuteUpdate(insertStmt);

        } catch (SQLException e) {
            throw e;
        }

    }

}
