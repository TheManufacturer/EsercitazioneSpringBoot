package com.example.FirstCrud.controllers;

import com.example.FirstCrud.entities.Car;
import com.example.FirstCrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarRepository carRepository;
    @PostMapping(path = "create")
    public Car createCar (@RequestBody Car car){
        return carRepository.saveAndFlush(car);
    }
    @GetMapping(path = "/read/{id}")
    public Car readCar (@PathVariable long id){
        Car car = null;
        if(!carRepository.existsById(id)){
            return car;
        }
        else {
            return carRepository.getById(id);
        }
    }

    @GetMapping(path = "/readall")
    public List<Car> readCars (){
        return carRepository.findAll();
    }


    @PatchMapping(path = "/update/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car car){
        Car nullcar = null;
        if (!carRepository.existsById(id)){
            return nullcar;
        }
        else {
            return carRepository.saveAndFlush(car);
        }
    }
    @DeleteMapping(path = "deleteone/{id}")
    public ResponseEntity<Car> deleteone(@PathVariable long id){
        boolean exist = carRepository.existsById(id);
        if(exist){
            carRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping(path = "deleteall")
    public void deleteAll (){
        carRepository.deleteAll();
    }
}