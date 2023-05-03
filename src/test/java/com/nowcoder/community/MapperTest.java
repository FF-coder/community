package com.nowcoder.community;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
//@MapperScan("com.nowcoder.community.dao.UserMapper")

public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById(){
        User user=userMapper.selectById(12);
        System.out.println(user);
    }
    @Test
    public void testUser(){
        User user=new User();
        System.out.println(user);
    }
}
