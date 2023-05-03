package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("impl1") //命名impl1
public class AlphadaoImpl1 implements AlphaDao{
    @Override
    public String select() {
        return "implement1";
    }
}
