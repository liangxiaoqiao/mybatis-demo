package com.source.mybatis;

import com.source.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author liangchao03
 * 2019/4/28
 */
public class Mybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatisConfig.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user;
        List<User> users;

        user = sqlSession.selectOne("com.source.mybatis.mapper.UserMapper.getById", 1);
        users = sqlSession.selectList("com.source.mybatis.mapper.UserMapper.getByName", "A");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        user = userMapper.getById(1);
        users = userMapper.getByName("A");
        System.out.println(user);
        System.out.println(users);
        sqlSession.close();
    }
}
