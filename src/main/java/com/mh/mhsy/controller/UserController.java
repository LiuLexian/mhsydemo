package com.mh.mhsy.controller;

import com.mh.mhsy.dto.user.UserDTO;
import com.mh.mhsy.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *  用户controller
 */
@Api(tags="用户接口")
@RestController
@RequestMapping("/mhsy/user")
@Slf4j
public class UserController {
    @Resource
    private IUserService userService;

    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    @ApiOperation(value="用户注册", notes="用户注册接口")
    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDTO){
        return userService.register(userDTO);
    }

    /**
     *  用户查询
     * @param userName
     * @param password
     * @return
     */
    @ApiOperation(value="用户查询", notes="用户查询接口")
    @GetMapping("/findUser")
    public String findUser(String userName,String password){
        return userService.findUser(userName,password);
    }

    /**
     *  发送验证码
     * @param qqAccount  qq账号
     * @return
     */
    @ApiOperation(value="验证码", notes="验证码接口")
    @GetMapping("/sendVerifyCode")
    public String sendVerifyCode(String qqAccount){
        return userService.sendVerifyCode(qqAccount);
    }
    /**
     *  充值接口
     * @param userId    用户id
     * @param userName  用户名
     * @param amount    金额
     * @param key       key
     * @return
     */
    @ApiOperation(value="充值", notes="充值接口")
    @GetMapping("/recharge")
    public String recharge(Integer userId,String userName,Integer amount,String key){
        return userService.recharge(userId,userName,amount,key);
    }

}
