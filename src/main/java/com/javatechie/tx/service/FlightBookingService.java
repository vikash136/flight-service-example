package com.javatechie.tx.service;

import com.javatechie.tx.dto.FightBookingRequest;
import com.javatechie.tx.dto.FlightBookingKnowledge;
import com.javatechie.tx.entity.PassengerInfo;
import com.javatechie.tx.entity.PaymentInfo;
import com.javatechie.tx.repository.PassengerInfoRepository;
import com.javatechie.tx.repository.PayementInfoRepository;
import com.javatechie.tx.util.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private PayementInfoRepository payementInfoRepository;
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;


    @Transactional
    public FlightBookingKnowledge bookFlightTicket(FightBookingRequest  reqest){

    PassengerInfo passengerInfo= reqest.getPassengerInfo();
        PassengerInfo saveinfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo=reqest.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPassengerId());
        paymentInfo.setAmmount(passengerInfo.getFare());
        payementInfoRepository.save(paymentInfo);
        return new FlightBookingKnowledge("Success",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);



    }
}
