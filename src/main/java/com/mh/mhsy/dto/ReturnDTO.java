package com.mh.mhsy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  返回 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnDTO<T> {
    /**
     *  状态码  1000  成功   999 失败
     */
    private Integer code;

    /**
     *  状态码对应解释
     */
    private String msg;

    /**
     *  返回数据
     */
    private T data;

}
