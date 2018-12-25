package com.domain;

import org.apache.ibatis.type.Alias;

/**
 * Created by chenyuan on 2018-04-15.
 */
@Alias("user")
public class User {

    //主键id
    private Integer id;

    //用户姓名
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
