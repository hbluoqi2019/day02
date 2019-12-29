package com.offcn.test;

import com.offcn.mapper.UserMapper;
import com.offcn.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Usertest {
    SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void init() throws IOException {
        //定义配置文件
        String resource = "mybatis-config.xml";
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        ////3.创建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user= new User(){{
            setId(1);
            setName("luo");
        }};
        User ret = mapper.findByUser(user);
        System.out.println(ret);
    }
    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(){{
            setId(1);
            setName("luo");
            setSex(1);
        }};
        int update = mapper.update(user);
        sqlSession.commit();
        System.out.println(update);
    }
    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
        }};
        List<User> byid = mapper.findByid(list);
        System.out.println(byid);
    }
}
