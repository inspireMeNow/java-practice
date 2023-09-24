package com.ray.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil
{

    /**
     * 创建一个SqlSession对象，用于外部调用
     * @return SqlSession
     */
    public static SqlSession getSqlSession()
    {
        try
        {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}