package com.mh.mhsy.service.impl;

import com.mh.mhsy.constant.Constant;
import com.mh.mhsy.dto.ReturnDTO;
import com.mh.mhsy.mapper.KeyMapper;
import com.mh.mhsy.service.IKeyService;
import com.mh.mhsy.util.JsonUtil;
import com.mh.mhsy.vo.Key;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("keyService")
public class KeyServiceImpl implements IKeyService {
    @Resource
    private KeyMapper keyMapper;

    @Override
    public String addKey(Key key) {
        ReturnDTO<Object> returnDTO = new ReturnDTO<Object>(Constant.CODE_999,Constant.CODE_999_MSG,null);
        try{
            if(key == null || StringUtils.isBlank(key.getCdKey()) || key.getUseDay() == null){
                throw new Exception("参数异常，key=null");
            }
            //判断卡密是否存在，存在则返回添加失败
            Map<String,Object> mapin = new HashMap<>(2);
            mapin.put("cdKey",key.getCdKey());
            List<Key> keys = keyMapper.findKeyList(mapin);
            if(!CollectionUtils.isEmpty(keys)){
                //添加卡密
                int count = keyMapper.addKey(key);
                if(count > 0){
                    //添加成功
                    returnDTO.setCode(Constant.CODE_1000);
                    returnDTO.setMsg(Constant.CODE_1000_MSG);
                }
            }else {
                //卡密重复
                returnDTO.setCode(Constant.CODE_1001);
                returnDTO.setMsg(Constant.CODE_1001_MSG);
            }
        }catch (Exception e){
            log.error("添加卡密异常："+e.getMessage(),e);
            e.printStackTrace();
        }
        return JsonUtil.toJson(returnDTO);
    }

    @Override
    public String findKeyList(String cdKey, Integer beginIndex, Integer endIndex) {
        ReturnDTO<Object> returnDTO = new ReturnDTO<Object>(Constant.CODE_999,Constant.CODE_999_MSG,null);
        try{
            Map<String,Object> mapin = new HashMap<>(4);
            mapin.put("cdKey",cdKey);
            mapin.put("beginIndex",beginIndex);
            mapin.put("endIndex",endIndex);
            List<Key> keys = keyMapper.findKeyList(mapin);
            returnDTO.setCode(Constant.CODE_1000);
            returnDTO.setMsg(Constant.CODE_1000_MSG);
            returnDTO.setData(keys);
        }catch (Exception e){
            log.error("添加卡密异常："+e.getMessage(),e);
            e.printStackTrace();
        }
        return JsonUtil.toJson(returnDTO);
    }
}
