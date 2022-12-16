package com.javatechie.tx.dto;

import com.javatechie.tx.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingKnowledge {

    private String status;
    private double totalfare;

    private String pnrNo;

    private PassengerInfo passengerInfo;
}
