package com.utils.spark;

import com.utils.spark.SparkSimpleOperations;

import org.apache.spark.api.java.JavaRDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rox on 07.12.2014.
 */
public class SparkUser {

    @Autowired
    private static SparkSimpleOperations ops;

    public static void initSpringContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ops = context.getBean(SparkSimpleOperations.class);
    }

    public static void getScalaMap() {
        List mapFromScala = Arrays.asList(ops.scalaDemoReturnMap());
        System.out.println("Number of letter A: " + mapFromScala.get(0));
        System.out.println("Number of letter B: " + mapFromScala.get(1));
    }

    public static void getScalaRDD() {
        JavaRDD<Object> rddFromScala = ops.scalaDemoReturnRDD().toJavaRDD();
        System.out.println("Entire RDD: " + rddFromScala);
    }
}
