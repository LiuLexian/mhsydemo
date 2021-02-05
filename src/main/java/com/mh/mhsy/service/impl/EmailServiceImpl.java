package com.mh.mhsy.service.impl;

import com.mh.mhsy.dto.email.EmailDTO;
import com.mh.mhsy.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("emailService")
public class EmailServiceImpl implements IEmailService {
//    @Resource
//    private JavaMailSender javaMailSender;



    @Override
    public String sendMail(EmailDTO<Object> emailDTO) {
        /**
         *  获取EmailDTO<Object>中各值，并将Object转换成文件
         */





        return null;
    }
}
