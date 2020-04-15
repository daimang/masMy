package com.example.template;

public class CarChanged extends AbstractEvent{

    private Long carId;
    private String carName;
    private int carPrice;
    private int carStock;
    private String imageUrl;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

    public int getCarStock() {
        return carStock;
    }

    public void setCarStock(int carStock) {
        this.carStock = carStock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
