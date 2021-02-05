package com.mh.mhsy.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
@ApiModel(value="userDTO", description="用户DTO目录")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不为空")
    @Length(min = 6,max = 20,message = "长度在6-20以内")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不为空")
    @Length(min = 6,max = 20,message = "长度在6-20以内")
    private String password;
    /**
     * QQ 账号
     */
    @ApiModelProperty(value = "QQ账号")
    @NotBlank(message = "QQ账号不为空")
    private String qqAccount;
    /**
     *  账户状态  0 无效  1 有效(默认)
     */
    private Integer validStatus = 1;
    /**
     * 创建时间 默认当前时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTIme = new Date();
    /**
     * 修改时间 默认当前时间
     */
    @ApiModelProperty(value = "修改时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime = new Date();
}
