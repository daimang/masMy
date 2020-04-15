package com.example.template;

import com.example.template.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
public class Application {

    protected static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Application.class, args);

        CarRepository carRepository = applicationContext.getBean(CarRepository.class);
        // 초기 상품 셋팅
        String[] cars = {"TV", "MASK", "NOTEBOOK", "TABLE", "CLOCK"};
        int i = 1;
        for(String p : cars){
            Car car = new Car();

            car.setImageUrl("https://github.githubassets.com/images/modules/profile/profile-joined-github.png");
            car.setName(p);
            car.setPrice(i*10000);
            car.setStock(i*10);
            car.setImageUrl("/goods/img/"+p+".jpg");

            // 상품 디테일 추가 - 양방향 관계
            CarOption carOption = new CarOption();
            carOption.setName(p + "_detail");
            carOption.setDesc(p + "_desc");
            carOption.setCar(car);

            CarOption carOption1 = new CarOption();
            carOption1.setName(p + "구매설명");
            carOption1.setDesc(p + "설명입니다");
            carOption1.setCar(car);

            car.addCarOptions(carOption);
            car.addCarOptions(carOption1);

            i++;
            carRepository.save(car);
        }
    }



}

