package com.example.demo.shell;


import com.example.demo.dto.CarDto;
import com.example.demo.service.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class ApplicationCommand {

    @Autowired
    private ParkinglotService parkinglotService;

    @ShellMethod
    public String create_parking_lot(int totalSlot){
        return parkinglotService.create(totalSlot);
    }

    @ShellMethod
    public String park(String regNo,String colour){
        return parkinglotService.park(regNo,colour);
    }
    @ShellMethod
    public String leave(int slotNo){
        return parkinglotService.leave(slotNo);
    }

    @ShellMethod
    public List<CarDto> status(){
        return parkinglotService.getStatus();
    }

    @ShellMethod
    public List<String> registrations_numbers_for_car_with_colour(String colour){
        return  parkinglotService.filterByColour(colour);
    }
}
