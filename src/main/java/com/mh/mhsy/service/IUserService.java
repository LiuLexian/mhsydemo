package com.mh.mhsy.service;

import com.mh.mhsy.dto.user.UserDTO;
import com.mh.mhsy.vo.User;

import java.util.List;

public interface IUserService {

    /**
     *  注册用户
     * @param userDTO
     * @return
     */
    String register(UserDTO userDTO);

    /**
     * 根据条件修改用户信息
     * @param userDTO
     * @return
     */
    String updateUser(UserDTO userDTO);

    /**
     *  根据条件查询用户集合
     * @param userDTO
     * @return
     */
    List<User> findUserList(UserDTO userDTO);


    /**
     *  查询用户
     * @param userName  用户名
     * @param password  密码
     * @return
     */
    String findUser(String userName,String password);

    /**
     * 发送验证码
     * @param qqAccount
     * @param qqAccount
     * @return
     */
    String sendVerifyCode(String qqAccount);

    /**
     *  充值接口
     * @param userId        用户id
     * @param userName      账户
     * @param amount        金额
     * @param key           key
     * @return
     */
    String recharge(Integer userId, String userName, Integer amount,String key);
}
