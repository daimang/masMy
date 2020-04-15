package com.example.template;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CarChanged extends AbstractEvent{

    private String stateMessage = "Car changed";

    private Long carId;
    private String carName;
    private int carPrice;
    private int carStock;
    private String imageUrl;

    public CarChanged(){
        super();
    }

    public CarChanged(Car car){
        this();
        this.setCarId(car.getId());
        this.setCarName(car.getName());
        this.setCarPrice(car.getPrice());
        this.setCarStock(car.getStock());
        this.setImageUrl(car.getImageUrl());
    }

    public Long getCarId() {
        return carId;
    }
    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public int getCarStock() {
        return carStock;
    }
    public void setCarStock(int carStock) {
        this.carStock = carStock;
    }

}
