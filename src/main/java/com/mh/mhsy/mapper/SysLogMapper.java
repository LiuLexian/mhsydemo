package com.mh.mhsy.mapper;

import com.mh.mhsy.vo.SysLog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysLogMapper {
    /**
     *  添加日志
     * @param sysLog
     * @return
     */
    Integer addLog(SysLog sysLog);

    /**
     *  查询日志记录
     * @param mapin
     * @return
     */
    List<SysLog> findLogList(Map<String,Object> mapin);
}
