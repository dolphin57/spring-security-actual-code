package io.dolphin.security.core.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: http请求返回的最外层对象
 * @Author: dolphin
 * @Since: 2021-5-15 11:54
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -2512067269292159149L;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}