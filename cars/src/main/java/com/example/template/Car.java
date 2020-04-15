package com.example.template;

import com.example.template.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    String name;
    int price;
    int stock;
    String imageUrl;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<CarOption> carOptions = new ArrayList<CarOption>();

    @PostPersist @PostUpdate
    private void publishStart() {
        CarChanged carChanged = new CarChanged(this);
        carChanged.publish();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<CarOption> getCarOptions() {
        return carOptions;
    }

    public void setCarOptions(List<CarOption> carOptions) {
        this.carOptions = carOptions;
    }

    public void addCarOptions(CarOption carOption){
        carOptions.add(carOption);
        carOption.setCar(this);
    }
}
