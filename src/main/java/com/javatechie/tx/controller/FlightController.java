package com.javatechie.tx.controller;

import com.javatechie.tx.dto.FightBookingRequest;
import com.javatechie.tx.dto.FlightBookingKnowledge;
import com.javatechie.tx.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@EnableTransactionManagement
public class FlightController {

    @Autowired
    private FlightBookingService flightBookingService;
    @PostMapping("/book")
    public FlightBookingKnowledge bookFlightTicket(@RequestBody FightBookingRequest request){
        return flightBookingService.bookFlightTicket(request);
    }
}
