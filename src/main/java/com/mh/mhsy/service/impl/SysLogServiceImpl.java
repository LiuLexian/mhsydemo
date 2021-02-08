package com.mh.mhsy.service.impl;

import com.mh.mhsy.mapper.SysLogMapper;
import com.mh.mhsy.service.IEmailService;
import com.mh.mhsy.service.ISysLogService;
import com.mh.mhsy.util.*;
import com.mh.mhsy.vo.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Slf4j
@Service("userService")
public class SysLogServiceImpl implements ISysLogService {
    @Resource
    private SysLogMapper sysLogMapper;
    @Resource
    private IEmailService emailService;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public String addLog(SysLog sysLog) {
        try{
            if(sysLog == null){
                throw new Exception("参数异常：log=null");
            }
            int count = sysLogMapper.addLog(sysLog);
            if(count <= 0){
                log.info("日志添加失败");
            }
        }catch (Exception e){
            log.error("添加日志异常："+e.getMessage(),e);
            e.printStackTrace();
        }



        return null;
    }

    @Override
    public String findLogList(String userId, Integer beginIndex, Integer endIndex) {







        return null;
    }
}
