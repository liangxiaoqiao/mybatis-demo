package com.source.mybatis.mapper;

import com.source.mybatis.User;

import java.util.List;

/**
 * @author liangchao03
 * 2019/4/28
 */
public interface UserMapper {
    void add(User user);

    User getById(int id);

    List<User> getByName(String name);
}
