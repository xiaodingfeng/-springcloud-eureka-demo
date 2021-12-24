package com.xiaobai.eurekaserviceprovider;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dingfeng.xiao
 */
@Mapper
public interface AdminDao extends IService<Admin> {
    /**
     * 获取一条信息
     * @return Admin
     */
    Admin get();
}
