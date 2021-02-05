package com.mh.mhsy.controller;

import com.mh.mhsy.dto.user.UserDTO;
import com.mh.mhsy.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用户controller
 */
@Api(tags="用户接口")
@RestController
@RequestMapping("/mhsy/user")
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value="用户注册", notes="用户注册接口")
    @PostMapping("/register")
    public String register(UserDTO userDTO){
        return userService.register(userDTO);
    }
}
