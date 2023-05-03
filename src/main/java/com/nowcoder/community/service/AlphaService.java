package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.dao.AlphadaoImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {
    @Autowired
    private AlphadaoImpl2 alphaDao;//注入数据库组件 此设为私有

    //调用alphaDao组件中的select
    public String selectDao(){
        return alphaDao.select();
    }

    public AlphaService()
    {
        System.out.println("实例化Alphaservice");
    }
    @PostConstruct
    public void init()
    {
        System.out.println("初始化Alphaservice");
    }
    @PreDestroy
    public void destroy()
    {
        System.out.println("销毁Alphaservice");
    }
}
