package com.utils.course;

import com.utils.spark.SparkSimpleOperations;
import com.utils.spark.SparkUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rox on 08.12.2014.
 */
public class Homework1 {

    @Autowired
    PascalTriangle testTriangle;

    @Autowired
    Balance testBalance;

    @Before
    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        testTriangle = context.getBean(PascalTriangle.class);
        testBalance = context.getBean(Balance.class);
    }

    @Test
    public void testPascalTriangle() {
        assertEquals(1, testTriangle.pascal(0, 2).intValue());
        assertEquals(2, testTriangle.pascal(1, 2).intValue());
        assertEquals(3, testTriangle.pascal(1, 3).intValue());
        assertEquals(4, testTriangle.pascal(1, 4).intValue());
        assertEquals(6, testTriangle.pascal(2, 4).intValue());
    }

    @Test
    public void testGetScalaMap() {
        assertEquals(true, testBalance.callBalance("a((b))"));
        assertEquals(false, testBalance.callBalance("a(b()"));
        // assertEquals(false, parenthesis.callBalance("ab())"));
    }
}
