package edu.ib.views;


public class CarRental {
    private int id_car_rentals;
    private int id_car;
    private double geocoor_rent_lat;
    private double  geocoor_rent_lon;
    private double geocoor_return_lat;
    private double  geocoor_return_lon;
    private String  date_rent;
    private String  date_return;

    @Override
    public String toString() {
        return "CarRental{" +
                "id_car_rentals=" + id_car_rentals +
                ", id_car=" + id_car +
                ", geocoor_rent_lat=" + geocoor_rent_lat +
                ", geocoor_rent_lon=" + geocoor_rent_lon +
                ", geocoor_return_lat=" + geocoor_return_lat +
                ", geocoor_return_lon=" + geocoor_return_lon +
                ", date_rent='" + date_rent + '\'' +
                ", date_return='" + date_return + '\'' +
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

    public double getGeocoor_return_lat() {
        return geocoor_return_lat;
    }

    public void setGeocoor_return_lat(double geocoor_return_lat) {
        this.geocoor_return_lat = geocoor_return_lat;
    }

    public double getGeocoor_return_lon() {
        return geocoor_return_lon;
    }

    public void setGeocoor_return_lon(double geocoor_return_lon) {
        this.geocoor_return_lon = geocoor_return_lon;
    }

    public String getDate_rent() {
        return date_rent;
    }

    public void setDate_rent(String date_rent) {
        this.date_rent = date_rent;
    }

    public String getDate_return() {
        return date_return;
    }

    public void setDate_return(String date_return) {
        this.date_return = date_return;
    }

    public CarRental(int id_car_rentals, int id_car, double geocoor_rent_lat, double geocoor_rent_lon, double geocoor_return_lat, double geocoor_return_lon, String date_rent, String date_return) {
        this.id_car_rentals = id_car_rentals;
        this.id_car = id_car;
        this.geocoor_rent_lat = geocoor_rent_lat;
        this.geocoor_rent_lon = geocoor_rent_lon;
        this.geocoor_return_lat = geocoor_return_lat;
        this.geocoor_return_lon = geocoor_return_lon;
        this.date_rent = date_rent;
        this.date_return = date_return;
    }
}
