package com.mh.mhsy.mapper;

import com.mh.mhsy.vo.Key;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface KeyMapper {
    /**
     *  添加key
     * @param key
     * @return
     */
    Integer addKey(Key key);

    /**
     *  查询key记录
     * @param mapin
     * @return
     */
    List<Key> findKeyList(Map<String,Object> mapin);
}
