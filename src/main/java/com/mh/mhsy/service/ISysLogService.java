package com.mh.mhsy.service;

import com.mh.mhsy.vo.SysLog;

import java.util.List;

public interface ISysLogService {

    /**
     *  添加日志
     * @param sysLog
     * @return
     */
    String addLog(SysLog sysLog);


    /**
     *  根据条件查询日志集合
     * @param userId        用户id
     * @param beginIndex    开始索引
     * @param endIndex      终止索引
     * @return
     */
    String findLogList(String userId,Integer beginIndex,Integer endIndex);


}
