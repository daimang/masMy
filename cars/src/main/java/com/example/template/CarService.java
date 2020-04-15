package com.example.template;

import com.example.template.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @StreamListener(KafkaProcessor.INPUT)
    public void onOrderPlaced(@Payload String message) {
        System.out.println("##### listener : " + message);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        OrderPlaced orderPlaced = null;
        try {
            orderPlaced = objectMapper.readValue(message, OrderPlaced.class);

            /**
             * 주문이 발생시, 수량을 줄인다.
             */
            if( orderPlaced.isMe()){

                Optional<Car> carOptional = carRepository.findById(orderPlaced.getCarId());
                Car car = carOptional.get();
                car.setStock(car.getStock() - orderPlaced.getQuantity());

                carRepository.save(car);

            }

            /**
             * 주문 취소시, 수량을 늘인다
             */
            if( orderPlaced.getEventType().equals(OrderCancelled.class.getSimpleName())){
                Optional<Car> carOptional = carRepository.findById(orderPlaced.getCarId());
                Car car = carOptional.get();
                car.setStock(car.getStock() + orderPlaced.getQuantity());

                carRepository.save(car);
            }

        }catch (Exception e){

        }
    }

    @Autowired
    CarRepository carRepository;

    /**
     * 상품 조회
     */
    public Car getCarById(Long id){

        Optional<Car> carOptional = carRepository.findById(id);
        Car car = carOptional.get();

        return car;
    }

    public Car save(String data){
        ObjectMapper mapper = new ObjectMapper();
        Car car = null;
        try {
            car = mapper.readValue(data, Car.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<CarOption> carOptions = car.getCarOptions();
        for(CarOption p : carOptions){
            p.setCar(car);
        }

        return carRepository.save(car);
    }
}
