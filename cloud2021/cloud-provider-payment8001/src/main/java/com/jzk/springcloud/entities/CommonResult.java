package com.jzk.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:CommonResult
 * Package:com.jzk.springcloud.entities
 * Description:
 *
 * @Date:2021/2/24 14:45
 * @Author:JIANGZHIKUAN
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
