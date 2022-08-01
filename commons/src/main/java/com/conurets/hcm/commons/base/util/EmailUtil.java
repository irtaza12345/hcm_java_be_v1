package com.conurets.hcm.commons.base.util;

import org.springframework.stereotype.Service;

@Service
public class EmailUtil {

    public static String TestEmail(String username){
        return String.format("%s has hit the email test service.",username);
    }
}