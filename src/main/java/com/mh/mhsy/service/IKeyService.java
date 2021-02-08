package com.mh.mhsy.service;

import com.mh.mhsy.vo.Key;

import java.util.List;

public interface IKeyService {

    /**
     *  添加卡密
     * @param key
     * @return
     */
    String addKey(Key key);


    /**
     *  根据条件查询卡密集合
     * @param cdKey         卡密
     * @param beginIndex    开始索引
     * @param endIndex      终止索引
     * @return
     */
    String findKeyList(String cdKey,Integer beginIndex,Integer endIndex);


}
