package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Car {

    String carNo;
    Slot slot;
    String colour;

}
