package com.example.template;

import com.example.template.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private CarRepository carRepository;

    /**
     * 상품 변경이 발생할때마다, 상품정보를 저장해 놓음
     */

    @StreamListener(KafkaProcessor.INPUT)
    public void onCarChanged(@Payload CarChanged carChanged) {
        try {
            if (carChanged.isMe()) {
                System.out.println("##### listener : " + carChanged.toJson());
                Car car = new Car();
                car.setId(carChanged.getCarId());
                car.setStock(carChanged.getCarStock());
                car.setName(carChanged.getCarName());
                car.setPrice(carChanged.getCarPrice());
                carRepository.save(car);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
