package com.conurets.hcm.commons.utils;

import org.springframework.stereotype.Service;

@Service
public class EmailUtils {

    public static String TestEmail(String username){
        System.out.println("Commons module is reachable.");
        return String.format("%s has hit the email test service.",username);
    }
}
