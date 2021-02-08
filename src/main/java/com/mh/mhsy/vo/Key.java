package com.mh.mhsy.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 秘钥key
 */
@Slf4j
@Data
public class Key {
    /**
     *  主键
     */
    private Integer id;
    /**
     *  用户id
     */
    private Integer userId;
    /**
     *  卡密  cdKey
     */
    private String cdKey;
    /**
     *  体验天数
     */
    private Integer useDay;
    /**
     * 使用状态 0 未使用（默认）  1 已使用
     */
    private Integer useStatus;
    /**
     *  生成时间
     */
    private Date createTime;
}
