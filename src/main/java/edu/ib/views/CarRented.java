package edu.ib.views;

public class CarRented {
    private int id_car_rentals;
    private int id_car;
    private double geocoor_rent_lat;
    private double  geocoor_rent_lon;
    private String  date_rent;


    public CarRented( int id_car_rentals, int id_car, double geocoor_rent_lat, double geocoor_rent_lon, double geocoor_return_lat, double geocoor_return_lon, String date_rent, String date_return) {
        this.id_car_rentals = id_car_rentals;
        this.id_car = id_car;
        this.geocoor_rent_lat = geocoor_rent_lat;
        this.geocoor_rent_lon = geocoor_rent_lon;
        this.date_rent = date_rent;

    }

    @Override
    public String toString() {
        return "CarRented{" +
                "id_car=" + id_car +
                ", geocoor_rent_lat=" + geocoor_rent_lat +
                ", geocoor_rent_lon=" + geocoor_rent_lon +
                ", date_rent='" + date_rent + '\'' +
                '}';
    }

    public int getId_car_rentals() {
        return id_car_rentals;
    }

    public void setId_car_rentals(int id_car_rentals) {
        this.id_car_rentals = id_car_rentals;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public double getGeocoor_rent_lat() {
        return geocoor_rent_lat;
    }

    public void setGeocoor_rent_lat(double geocoor_rent_lat) {
        this.geocoor_rent_lat = geocoor_rent_lat;
    }

    public double getGeocoor_rent_lon() {
        return geocoor_rent_lon;
    }

    public void setGeocoor_rent_lon(double geocoor_rent_lon) {
        this.geocoor_rent_lon = geocoor_rent_lon;
    }


    public String getDate_rent() {
        return date_rent;
    }

    public void setDate_rent(String date_rent) {
        this.date_rent = date_rent;
    }


}
