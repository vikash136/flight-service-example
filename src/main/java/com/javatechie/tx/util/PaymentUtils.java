package com.javatechie.tx.util;

import com.javatechie.tx.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String,Double>paymentMap=new HashMap<>();

    static {
        paymentMap.put("ac1",12000.00);
        paymentMap.put("ac2",1000.00);
        paymentMap.put("ac3",600.00);
        paymentMap.put("ac4",45000.00);
    }

    public static boolean validateCreditLimit(String accNo,double paidAmout ){
        if(paidAmout>paymentMap.get(accNo)){
            throw new InsufficientAmountException("Insuficient Fund!!!!!!!!!!!!!");
        }else {
            return true;
        }
    }
}


