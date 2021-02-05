package com.mh.mhsy.mapper;

import com.mh.mhsy.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserMapper {
    /**
     *  添加用户
     * @param user
     * @return
     */
    Integer registerUser(User user);

    /**
     *  根据条件修改用户信息
     * @param mapin
     * @return
     */
    Integer updateUser(Map<String, Object> mapin);

    /**
     * 根据条件查询用户集合
     * @param mapin
     * @return
     */
    List<User> findUserList(Map<String,Object> mapin);

    /**
     *  校验用户是否存在
     * @param mapin
     * @return
     */
    Integer checkUser(Map<String,Object> mapin);

    User findUser(Map<String,Object> mapin);
}
