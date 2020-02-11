package edu.ib.dbClasses;
import edu.ib.views.CarAdmin;
import edu.ib.views.CarRental;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private DBUtilAdmin dbUtil;

    public AdminDao(DBUtilAdmin dbUtil) throws SQLException, ClassNotFoundException {
        this.dbUtil = dbUtil;
    }
    public ObservableList<CarAdmin> showAllCars() throws SQLException, ClassNotFoundException {

        String selectStmt = "select * from cars";

        try {
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<CarAdmin> cars = getAllCars(resultSet);
            return cars;


        } catch (SQLException e) {
            throw e;
        }

    }
    private ObservableList<CarAdmin> getAllCars(ResultSet rs) throws SQLException {
        ObservableList<CarAdmin> cars = FXCollections.observableArrayList();
        while (rs.next()) {
            CarAdmin carAdmin = new CarAdmin(rs.getInt("id_car"), rs.getString("car_name"), rs.getString("brand"),rs.getString("registration_number"),rs.getString("insurance_end_date"),rs.getString("low_battery"),rs.getDouble("odometer"));
            cars.add(carAdmin);
        }

        return cars;
    }
    public ObservableList<CarAdmin> showAvailableCars() throws SQLException, ClassNotFoundException {

        String selectStmt = "select * from notRentedCars";

        try {
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<CarAdmin> cars = getAvailableCars(resultSet);
            return cars;


        } catch (SQLException e) {
            throw e;
        }

    }
    private ObservableList<CarAdmin> getAvailableCars(ResultSet rs) throws SQLException {
        ObservableList<CarAdmin> cars = FXCollections.observableArrayList();
        while (rs.next()) {
            CarAdmin carAdmin = new CarAdmin(rs.getInt("id_car"), rs.getString("car_name"), rs.getString("brand"),rs.getString("registration_number"),rs.getString("insurance_end_date"),rs.getString("low_battery"),rs.getDouble("odometer"));
            cars.add(carAdmin);
        }

        return cars;
    }
    public ObservableList<CarRental> showRentalsWhereCarID(int id) throws SQLException, ClassNotFoundException {
        StringBuilder selectStmt = new StringBuilder("select * from car_rentals where id_car=");
        selectStmt.append(id);
        selectStmt.append(";");
        try {
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt.toString());
            ObservableList<CarRental> cars = getRentalsWhereCarID(resultSet);
            return cars;
        } catch (SQLException e) {
            throw e;
        }

    }
    private ObservableList<CarRental> getRentalsWhereCarID(ResultSet rs) throws SQLException {
        ObservableList<CarRental> cars = FXCollections.observableArrayList();
        while(rs.next()){
            CarRental carRental = new CarRental(rs.getInt("id_car_rentals"),rs.getInt("id_car"), rs.getDouble("geocoor_rent_lat"),rs.getDouble("geocoor_rent_lon"), rs.getDouble("geocoor_return_lat"),rs.getDouble("geocoor_return_lon"),rs.getString("date_rent"),rs.getString("date_return") );
            cars.add(carRental);
        }

        return cars;
    }
    public ObservableList<String> showAllDates() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT distinct date(date_return) as date from car_rentals;";
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<String> dates = getAllDates(resultSet);
            return dates;
    }
    private ObservableList<String> getAllDates(ResultSet rs) throws SQLException {
        ObservableList<String> dates = FXCollections.observableArrayList();
        while (rs.next()) {
        String date=rs.getString("date");
            dates.add(date);
        }
        return dates;
    }
    public double getEarningsFromDay(String date) throws SQLException, ClassNotFoundException {
        StringBuilder selectStmt=new StringBuilder("select sum(c.charge) as earnings from charges c join  car_rentals cr on c.id_car_rentals=cr.id_car_rentals WHERE DATE(cr.date_return) ='");
       selectStmt.append(date);
       selectStmt.append("'");
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt.toString());
        double earnings=0;
        while (resultSet.next()) {
             earnings=resultSet.getDouble("earnings");
        }
        return earnings;
    }
    public void chargeCar(int id) throws SQLException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder("UPDATE cars set odometer=0.0,low_battery='N' where id_car=");
        sb.append(id);
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
