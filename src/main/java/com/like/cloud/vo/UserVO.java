package com.like.cloud.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author Ke
 * @Date 2019/10/16 16:26
 * @Version 1.0
 */
@Data
public class UserVO implements Serializable {

    private int id;
    private String name;

}
