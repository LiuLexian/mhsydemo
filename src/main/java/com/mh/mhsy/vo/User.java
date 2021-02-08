package com.mh.mhsy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户对象
 */
@ApiModel(value="t_user对象", description="用户目录")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
//    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * QQ 账号
     */
    @ApiModelProperty(value = "QQ账号")
    private String qqAccount;
    /**
     *  账户状态  0 无效  1 有效(默认)
     */
    private Integer validStatus = 1;
    /**
     *  生效时间
     */
    @ApiModelProperty(value = "生效时间")
    private Date startTime;
    /**
     *  失效时间
     */
    @ApiModelProperty(value = "失效时间")
    private Date endTime;
    /**
     * 创建时间 默认当前时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTIme = new Date();
    /**
     * 修改时间 默认当前时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime = new Date();


}
