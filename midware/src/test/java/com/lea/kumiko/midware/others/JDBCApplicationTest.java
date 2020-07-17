package com.lea.kumiko.midware.others;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class JDBCApplicationTest {

    @Before
    public void loadDriver() throws ClassNotFoundException {
        System.out.println("start loading driver");

    }

    /**
     *      https://www.cnblogs.com/fzz9/p/8970210.html
     *      https://github.com/ZhangZiSheng001/jdbc-demo
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void testJDBC() throws ClassNotFoundException {



    }


}
