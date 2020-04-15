package com.example.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CarService carService;

    @GetMapping("/car/{carId}")
    Car carStockCheck(@PathVariable(value = "carId") Long carId) {

//        System.out.println("carStockCheck call");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return  this.carService.getCarById(carId);
    }

    @PostMapping("/car")
    Car carInsert(@RequestBody String data) {
        System.out.println(data);
        return this.carService.save(data);
    }

}
