package com.mh.mhsy.controller;

import com.mh.mhsy.dto.email.EmailDTO;
import com.mh.mhsy.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *  邮件服务 Controller
 */
@RestController
public class EmailController {

    @Autowired
    private IEmailService emailService;

    /**
     *  发送邮件
     * @param emailDTO
     * @return
     */
    public String sendMail(EmailDTO<Object> emailDTO){
        return emailService.sendMail(emailDTO);
    }

}
