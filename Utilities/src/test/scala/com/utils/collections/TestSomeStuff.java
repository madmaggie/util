package com.utils.course;

import com.utils.collections.SomeSuff;
import com.utils.spark.SparkSimpleOperations;
import com.utils.spark.SparkUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rox on 08.12.2014.
 */
public class TestSomeStuff {

    @Autowired
    SomeSuff test;


    @Before
    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        test = context.getBean(SomeSuff.class);

    }

    @Test
    public void testStringBufferOutput() throws IOException {
        System.out.println(test.convertToCSVFormat(test.readDataFromInstrumentAndPosition()));
       // assertEquals(6, testTriangle.pascal(2, 4).intValue());
    }


}
