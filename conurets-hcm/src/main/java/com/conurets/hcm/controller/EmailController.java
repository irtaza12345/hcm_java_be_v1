package com.conurets.hcm.controller;

import com.conurets.hcm.commons.base.dto.response.BaseResponseDTO;
import com.conurets.hcm.commons.base.util.EmailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(value = "/api/email/")
public class EmailController {

    @ResponseBody
    @GetMapping(value = "/api/email/testEmail")
    public BaseResponseDTO<?> TestEmail(){

        BaseResponseDTO <String> baseResponseDTO = new BaseResponseDTO<>();
        baseResponseDTO.setData(EmailUtil.TestEmail("Hassan Adnan"));
        return baseResponseDTO;
    }
}
