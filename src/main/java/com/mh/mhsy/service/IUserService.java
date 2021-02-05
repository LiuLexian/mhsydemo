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
    Integer updateUser(UserDTO userDTO);

    /**
     *  根据条件查询用户集合
     * @param userDTO
     * @return
     */
    List<User> findUserList(UserDTO userDTO);

    /**
     * 校验用户是否存在  根据userName qqAccount
     * @param userName
     * @param qqAccount
     * @return
     */
    boolean checkUser(String userName,String qqAccount);
}
