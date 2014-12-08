package com.utils.spark;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rox on 08.12.2014.
 */
public class SparkTest {

    SparkUser testSparkUser = new SparkUser();

    @Before
    public void init() {
        testSparkUser.initSpringContext();
    }

    @Test
    public void testGetScalaMap() {
        testSparkUser.getScalaMap();
    }
}