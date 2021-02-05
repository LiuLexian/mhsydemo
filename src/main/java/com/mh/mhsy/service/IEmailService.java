package com.mh.mhsy.service;

import com.mh.mhsy.dto.email.EmailDTO;

public interface IEmailService {
    /**
     *  发送文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleMail(String to, String subject, String content);
    /**
     * 发送HTML邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlMail(String to, String subject, String content);
    /**
     * 发送带附件的邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);



    /**
     *  发送邮件
     * @param emailDTO
     * @return
     */
    String sendMail(EmailDTO<Object> emailDTO);
}
