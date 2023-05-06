package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    //分页查询 1首页帖子 （id=0）/2个人主页帖子（id！=0）
    //offset:起始行号  limit：每页几条

    int selectDiscussPostRows(@Param("userId") int userId);
    // @Param注解用于给参数取别名,（）里为别名
    // 如果只有一个参数,并且在动态sql <if>里使用,则必须加别名.
    //查询某个id的帖子数量（id！=0） id=0考虑首页情况
}
