package com.offcn.test;
import com.offcn.mapper.PersonMapper;
import com.offcn.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Persontest {
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
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            List<Person> all = mapper.findAll();
            System.out.println(all.get(0).getName());
        }
        @Test
    public void test2(){
            SqlSession sqlSession = sqlSessionFactory.openSession();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person byId1 = mapper.findById(1);
            sqlSession.close();
            System.out.println("-------------------------------------------");
            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            PersonMapper mapper2 = sqlSession2.getMapper(PersonMapper.class);
            Person byId2 = mapper2.findById(1);
            System.out.println(byId1);
        }

}
