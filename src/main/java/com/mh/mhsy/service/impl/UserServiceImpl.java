package com.mh.mhsy.service.impl;

import com.mh.mhsy.dto.ReturnDTO;
import com.mh.mhsy.dto.user.UserDTO;
import com.mh.mhsy.mapper.UserMapper;
import com.mh.mhsy.service.IUserService;
import com.mh.mhsy.util.JsonUtil;
import com.mh.mhsy.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public String register(UserDTO userDTO) {
        ReturnDTO<Object> returnDTO = new ReturnDTO<Object>(999,"注册失败",null);
        try{
            if(userDTO == null){
                throw new Exception("用户信息异常，userDTO="+userDTO);
            }
            Date date = new Date();
            //验证是否已存在
            if(!checkUser(userDTO.getUserName(),userDTO.getQqAccount())){
                User user = new User();
                BeanUtils.copyProperties(userDTO,user);
                int count = userMapper.registerUser(user);
                if(count > 0){
                    returnDTO.setCode(1000);
                    returnDTO.setMsg("注册成功");
                }
            }else{
                returnDTO.setCode(9999);
                returnDTO.setMsg("用户名已存在，请更换用户名");
            }
        }catch (Exception e){
            log.error("注册用户异常",e);
            e.printStackTrace();

        }
        return JsonUtil.toJson(returnDTO);
    }

    @Override
    public Integer updateUser(UserDTO userDTO) {




        return null;
    }

    @Override
    public List<User> findUserList(UserDTO userDTO){




        return null;
    }

    @Override
    public boolean checkUser(String userName,String qqAccount) {
        boolean flag = false;
        if(StringUtils.isBlank(userName)){
            log.info("参数异常，用户名为空：userName="+userName);
        }else{
            Map<String,Object> mapin = new HashMap<>(2);
            mapin.put("userName",userName);
            mapin.put("qqAccount",qqAccount);
            int count = userMapper.checkUser(mapin);
            if(count > 0){
                flag = true;
            }
        }
        return false;
    }
}