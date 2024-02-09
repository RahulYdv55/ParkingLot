package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {
    int slot;
    String carNo;
    String colour;
}
