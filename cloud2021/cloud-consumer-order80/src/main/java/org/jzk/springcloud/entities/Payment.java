package org.jzk.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName:Payment
 * Package:com.jzk.springcloud.entities
 * Description:
 *
 * @Date:2021/2/24 14:43
 * @Author:JIANGZHIKUAN
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
