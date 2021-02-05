package com.mh.mhsy.dto.user;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  玩家角色信息 DTO  用于写入excel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    /**
     *  角色邮箱账号
     */
    @Excel(name = "邮箱账号", width = 15)
    private String emailAccount;
    /**
     *  邮箱密码 用户不填则为空
     */
    @Excel(name = "邮箱密码", width = 15)
    private String emailPassword;
    /**
     *  服务器
     */
    @Excel(name = "服务器", width = 15)
    private String serverName;
    /**
     * 大区
     */
    @Excel(name = "大区", width = 15)
    private String regionName;
    /**
     * 玩家名
     */
    @Excel(name = "角色名称", width = 15)
    private String player;
    /**
     * 玩家等级
     */
    @Excel(name = "角色等级", width = 15)
    private Integer playerLevel;
    /**
     * 金币数量
     */
    @Excel(name = "金币数量", width = 15)
    private Integer goldCoin;
    /**
     * 银币数量
     */
    @Excel(name = "银币数量", width = 15)
    private Integer silverCoin;
    /**
     *  账号安全类型 默认0 安全  1 锁账号  2 隔离
     */
    @Excel(name = "安全等级", width = 10)
    private Integer safeType;
}
