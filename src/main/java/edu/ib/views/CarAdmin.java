package edu.ib.views;

public class CarAdmin{
    private int id_car;
    private String car_name;
    private String brand;
    private String registration_number;
    private String insurance_end_date;
    private String low_battery;
    private double odometer;

    @Override
    public String toString() {
        return "CarAdmin{" +
                "id_car=" + id_car +
                ", car_name='" + car_name + '\'' +
                ", brand='" + brand + '\'' +
                ", registration_number=" + registration_number +
                ", insurance_end_date='" + insurance_end_date + '\'' +
                ", low_battery='" + low_battery + '\'' +
                ", odometer='" + odometer + '\'' +
                '}';
    }

    public CarAdmin(int id_car, String car_name, String brand, String registration_number, String insurance_end_date, String low_battery, double odometer) {
        this.id_car = id_car;
        this.car_name = car_name;
        this.brand = brand;
        this.registration_number = registration_number;
        this.insurance_end_date = insurance_end_date;
        this.low_battery = low_battery;
        this.odometer = odometer;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getInsurance_end_date() {
        return insurance_end_date;
    }

    public void setInsurance_end_date(String insurance_end_date) {
        this.insurance_end_date = insurance_end_date;
    }

    public String getLow_battery() {
        return low_battery;
    }

    public void setLow_battery(String low_battery) {
        this.low_battery = low_battery;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }
}
