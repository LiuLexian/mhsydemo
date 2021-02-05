package com.mh.mhsy.service;

import com.mh.mhsy.dto.email.EmailDTO;

public interface IEmailService {

    /**
     *  发送邮件
     * @param emailDTO
     * @return
     */
    String sendMail(EmailDTO<Object> emailDTO);
}
