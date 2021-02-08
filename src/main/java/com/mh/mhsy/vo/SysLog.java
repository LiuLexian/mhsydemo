package com.mh.mhsy.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 操作日志
 */
@Slf4j
@Data
public class SysLog {
    /**
     * 主键
     */
    private Integer id;
    /**
     *  用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 操作类型  1：注册  2：修改  3：充值
     */
    private Integer type;
    /**
     *  操作信息
     */
    private String operation;
    /**
     * 操作ip
     */
    private String operateIp;
    /**
     * 充值金额  预留字段，暂时还未考虑好以哪种支付方式
     */
    private Integer amount;
    /**
     *  创建日期
     */
    private Date createTime;

}
