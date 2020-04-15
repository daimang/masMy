package com.example.template;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByName(@Param("name") String name);
}
