package com.example.demo.service;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import com.example.demo.model.ParkingLot;
import com.example.demo.model.Slot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.model.ParkingLot.cleateClass;

@Service
public class ParkinglotService {

    private ParkingLot parkingLot;

    public String create(int slot){
        parkingLot=cleateClass(slot);
        return "Created a parking lot with "+slot+" slots";
    }

    public String park(String carNo,String colour){
        if(parkingLot.getSlots().size()==0){
            return "Sorry parking lot is full";
        }
        Slot slot = parkingLot.getSlots().poll();
        Car car = Car.builder().carNo(carNo).colour(colour).slot(slot).build();
        parkingLot.getSlotBooked().add(car);
        return "Allocated slot number: "+slot.getSlotNo();
    }

    public String leave(int no){
        List<Car> cars = parkingLot.getSlotBooked().stream().filter(car->car.getSlot().getSlotNo()==no).collect(Collectors.toList());
        parkingLot.getSlotBooked().remove(cars.get(0));
        parkingLot.getSlots().add(new Slot(no));
        return "Slot number "+ no +" is free";
    }

    public  List<CarDto> getStatus(){
        List<CarDto> carDtos = new ArrayList<>();
        for(Car c:parkingLot.getSlotBooked()){
            carDtos.add(CarDto.builder().carNo(c.getCarNo()).colour(c.getColour()).slot(c.getSlot().getSlotNo()).build());
        }
        return carDtos;
    }

    public List<String> filterByColour(String colour){
        List<String> cars = parkingLot.getSlotBooked().stream().filter(car->car.getColour().equals(colour)).map(car->car.getCarNo()).collect(Collectors.toList());
//        List<String> cars = new ArrayList<>();
//        for(Car c:parkingLot.getSlotBooked()){
//            if(c.getColour().equalsIgnoreCase(colour))
//                cars.add(c.getCarNo());
//        }
        return cars;
    }
}
