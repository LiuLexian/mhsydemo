package com.mh.mhsy.dto.email;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 邮件发送 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO<T> {
    /**
     *  发送方
     */
    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "发送方不能为空")
    private String sender;
    /**
     *  接收方
     */
    private String[] receives;
    /**
     *  邮件主题
     */
    private String subject;
    /**
     *  邮件正文
     */
    private String content;
    /**
     *  邮件附件
     */
    private T object;

    /**
     *  保存时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date saveTime;
}
