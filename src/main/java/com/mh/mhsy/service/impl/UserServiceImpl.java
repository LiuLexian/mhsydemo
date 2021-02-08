package com.mh.mhsy.service.impl;

import com.mh.mhsy.constant.Constant;
import com.mh.mhsy.dto.ReturnDTO;
import com.mh.mhsy.dto.user.UserDTO;
import com.mh.mhsy.mapper.UserMapper;
import com.mh.mhsy.service.IEmailService;
import com.mh.mhsy.service.IUserService;
import com.mh.mhsy.util.*;
import com.mh.mhsy.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    @Resource
    private IEmailService emailService;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public String register(UserDTO userDTO) {
        ReturnDTO<Object> returnDTO = new ReturnDTO<Object>(Constant.CODE_999,Constant.CODE_999_MSG,null);
        try{
            if(userDTO == null){
                throw new Exception("用户信息异常，userDTO="+userDTO);
            }
            Date date = new Date();
            //校验用户是否存在
            boolean flag = checkUser(userDTO.getUserName(),null,userDTO.getQqAccount());
            //验证是否已存在
            if(!flag){
                //从redis中获取验证码，并进行对比，一致后，则允许进行下一步注册
                String verifyCode = (String)redisUtil.get(userDTO.getQqAccount());
                if(!StringUtils.isBlank(verifyCode) && verifyCode.equals(userDTO.getVerifyCode())){
                    User user = new User();
                    BeanUtils.copyProperties(userDTO,user);
                    //注册用户 ，默认有1天免费使用权限
                    user.setStartTime(date);
                    user.setEndTime(TimeUtil.getOneDay(date,Constant.NUMBER_1));
                    int count = userMapper.registerUser(user);
                    if(count > 0){
                        returnDTO.setCode(Constant.CODE_1000);
                        returnDTO.setMsg(Constant.CODE_1000_MSG);
                        returnDTO.setData(userDTO.getUserName());
                    }
                    log.info("用户【"+userDTO.getUserName()+"】注册成功，时间："+date);
                }
            }else{
                returnDTO.setCode(Constant.CODE_1001);
                returnDTO.setMsg(Constant.CODE_1001_MSG);
            }
        }catch (Exception e){
            log.error("注册用户异常",e);
            e.printStackTrace();
        }
        return JsonUtil.toJson(returnDTO);
    }

    @Override
    public String updateUser(UserDTO userDTO) {
        ReturnDTO<Object> returnDTO = new ReturnDTO<Object>(Constant.CODE_999,Constant.CODE_999_MSG,null);
        try{
            /**
             * 修改账户
             * 1.通过账户密码，检验是否可进行修改操作
             * 2.通过校验后，进行修改
             * 3.将修改结果传给前台
             */
            if(userDTO == null){
                throw new Exception("参数异常：userDTO="+userDTO);
            }
            //校验用户是否存在
            boolean flag = checkUser(userDTO.getUserName(),userDTO.getPassword(),null);
            Date date = new Date();
            if(flag){
               Map mapin = new HashMap();
               mapin.put("password",userDTO.getNewPassword());
               mapin.put("qqAccount",userDTO.getQqAccount());
               int count = userMapper.updateUser(mapin);
               if(count > 0){
                   returnDTO.setCode(Constant.CODE_1000);
                   returnDTO.setMsg(Constant.CODE_1000_MSG);
                   log.info("用户【"+userDTO.getUserName()+"】在【"+TimeUtil.dateToString(date, "yyyy-MM-DD HH:mm:ss")+"】修改信息");
               }
            }


        }catch (Exception e){

        }
        return JsonUtil.toJson(returnDTO);
    }

    @Override
    public List<User> findUserList(UserDTO userDTO){




        return null;
    }

    @Override
    public String findUser(String userName, String password) {
//        emailService.sendSimpleMail("1142080948@qq.com","主题：你好普通邮件","内容：第一封邮件");
        ReturnDTO<Object> returnDTO = new ReturnDTO<Object>(999,"查询异常",null);
        try{
            if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
                throw new Exception("用户查询异常，账号：userName="+userName);
            }
            Map map = new HashMap();
            map.put("userName",userName);
            map.put("password",password);
            map.put("validStatus",1);
            List<User> users = userMapper.findUserList(map);
            if(!CollectionUtils.isEmpty(users)){
                returnDTO.setCode(1000);
                returnDTO.setMsg("查询成功");
                returnDTO.setData(users.get(0));
            }else{
                returnDTO.setCode(1000);
                returnDTO.setMsg("查询成功，该用户不存在");
            }
        }catch (Exception e){
            log.error("查询用户信息异常",e);
            e.printStackTrace();
        }
        return JsonUtil.toJson(returnDTO);
    }

    @Override
    public String sendVerifyCode(String qqAccount) {
        ReturnDTO<Object> returnDTO = new ReturnDTO<Object>(Constant.CODE_999,Constant.CODE_999_MSG,null);
        try{
            /**
             *  发送验证码
             *  1.系统生成随机验证码
             *  2.清空redis中存在相同key 的value
             *  3.将生成的验证码放入key的value中
             *  4.将验证码通过邮件发送给用户
             */
            if(StringUtils.isBlank(qqAccount)){
                throw new Exception("参数异常");
            }
            String verifyCode = StringUtil.createStr(6);
            redisUtil.set(qqAccount,verifyCode,Constant.NUMBER_30000);
            String subject = "注册";
            String content = "验证码："+verifyCode+"，有效期5分钟，请尽快使用";
            emailService.sendSimpleMail(qqAccount+"@qq.com",subject,content);
            returnDTO.setCode(Constant.CODE_1000);
            returnDTO.setMsg(Constant.CODE_1000_MSG);
            returnDTO.setData(null);
        }catch (Exception e){
            log.error("发送验证码异常："+e.getMessage(),e);
            e.printStackTrace();
        }
        return JsonUtil.toJson(returnDTO);
    }

    @Override
    public String recharge(Integer userId, String userName, Integer amount, String key) {
        ReturnDTO<Object> returnDTO = new ReturnDTO<Object>(Constant.CODE_999,Constant.CODE_999_MSG,null);
        try{
            if(userId == null || userId <= 0 || StringUtils.isBlank(userName) || ((amount == null || amount < 0) && StringUtils.isBlank(key))){
                throw new Exception("参数异常：userId"+userId+",userName="+userName+",amount="+amount+",key="+key);
            }
            //



        }catch (Exception e){
            log.error("充值异常："+e.getMessage(),e);
            e.printStackTrace();
        }
        return JsonUtil.toJson(returnDTO);
    }

    /**
     *  校验用户是否存在
     * @param userName
     * @param qqAccount
     * @return
     * @throws Exception
     */
    private boolean checkUser(String userName,String password,String qqAccount) throws Exception {
        boolean flag = false;
        if(StringUtils.isBlank(userName)){
            log.info("参数异常，用户名为空：userName="+userName);
            throw new Exception("参数异常，用户名为空：userName="+userName);
        }else{
            Map<String,Object> mapin = new HashMap<>(2);
            mapin.put("userName",userName);
            mapin.put("password",password);
            mapin.put("qqAccount",qqAccount);
            int count = userMapper.checkUser(mapin);
            if(count > 0){
                flag = true;
            }
        }
        return false;
    }

    /**
     *  发送邮件
     * @param to
     * @param subject
     * @param content
     * @return
     */
    private boolean sendVerifyCodeMail(String to,String subject,String content,String verifyCode){
        boolean flag = false;
        try{
            if (StringUtils.isBlank(to)){
                throw new Exception("收件人为空");
            }
            content = content.replace("{veriftyCode}",verifyCode);
            emailService.sendSimpleMail(to,subject,content);
            flag = true;
        }catch (Exception e){
            log.error("发送邮件异常："+e.getMessage(),e);
            e.printStackTrace();
        }
        return flag;
    }
}
