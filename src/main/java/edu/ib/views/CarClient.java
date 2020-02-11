package edu.ib.views;

public class CarClient {
    private int id_car;
    private String car_name;
    private String brand;
    private double rate;

    @Override
    public String toString() {
        return "CarClient{" +
                "id_car=" + id_car +
                ", car_name='" + car_name + '\'' +
                ", brand='" + brand + '\'' +
                ", rate=" + rate +
                '}';
    }

    public CarClient(int id_car, String car_name, String brand, double rate) {
        this.id_car = id_car;
        this.car_name = car_name;
        this.brand = brand;
        this.rate = rate;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
