package com.example.demo.model;

import lombok.Data;
import lombok.Synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Data
public class ParkingLot {

    private static ParkingLot parkingLot;
    private int totalSlot;
    private PriorityQueue<Slot> slots;
    private List<Car> slotBooked;

    private ParkingLot(int slot){
        this.totalSlot=slot;
        this.slots=new PriorityQueue<>((slot1,slot2)->(slot1.getSlotNo()-slot2.getSlotNo()));
        slotBooked=new ArrayList<>();
        for(int i=1;i<=slot;i++){
            slots.add(new Slot(i));
        }
    }

    public static synchronized ParkingLot  cleateClass(int slot){
        if(parkingLot==null)
            parkingLot=new ParkingLot(slot);
        return parkingLot;
    }




}
