package com.baproject.msaccountservice.utils;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

import java.util.Random;
import java.util.logging.Logger;

public class AccountNumberGenerator implements ValueGenerator<String> {

    Logger log = Logger.getLogger(AccountNumberGenerator.class.getSimpleName());

    //this is for random number starting from 1 and 2 (10 digits).
    @Override
    public String generateValue(Session session, Object owner) {
        Random r = new Random(System.currentTimeMillis());
        String acc_number=String.valueOf(1000000000 + r.nextInt(2000000000));
                log.info("Generated account number: "+acc_number);
       // return String.valueOf(1000000000 + r.nextInt(2000000000));
        return acc_number;
    }
}
