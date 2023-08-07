package com.baproject.msaccountservice.utils;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;


import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountCreationDate implements ValueGenerator<String> {

    public String generateValue(Session session, Object owner){
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String timestamp = DateFor.format(date);
        return timestamp;
    }
}
