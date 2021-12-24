package com.xiaobai.eurekaserviceprovider;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author dingfeng.xiao
 */
@TableName(value = "admin")
public class Admin {
    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
