package com.example.template;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeliveryStarted extends AbstractEvent{

    private String stateMessage = "Delivery started";

    private Long deliveryId;
    private Long orderId;
    private int quantity;
    private Long carId;
    private String carName;
    private String customerId;
    private String customerName;
    private String deliveryAddress;
    private String deliveryState;

    public DeliveryStarted(){
        super();
    }
    public DeliveryStarted(Delivery delivery){
        this();
        this.setOrderId(delivery.getOrderId());
        this.setDeliveryId(delivery.getDeliveryId());
        this.setQuantity(delivery.getQuantity());
        this.setCustomerId(delivery.getCustomerId());
        this.setCustomerName(delivery.getCustomerName());
        this.setDeliveryAddress(delivery.getDeliveryAddress());
        this.setCarId(delivery.getCarId());
        this.setCarName(delivery.getCarName());
        this.setDeliveryState(this.getClass().getSimpleName());
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
