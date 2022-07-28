package com.conurets.hcm.controller;

import com.conurets.hcm.commons.utils.EmailUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/email/")
public class EmailController {

    @GetMapping(value = "testEmail")
    public String TestEmail(){

        return EmailUtils.TestEmail("Hassan Adnan");
    }
}
