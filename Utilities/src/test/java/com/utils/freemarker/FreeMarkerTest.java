package com.utils.freemarker;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Rox on 16.11.2014.
 */
public class FreeMarkerTest {

    private FreeMarker myFreeMarker = new FreeMarker();

    @Before
    public void generateMovie() {
        myFreeMarker.initConfig();
    }

    @Test
    public void calculateToBeMoved() {
        // GIVEN
        TemplateClass input = new TemplateClass("John Snow", 23);

        // WHEN
        String compareConcat = null;
        try {
            List<String> compare = FileUtils.readLines(new File("src\\test\\resources\\freeMarkerTest.txt"));
            for (String s: compare) {
                compareConcat = compareConcat + s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // THEN
        String result = myFreeMarker.processTemplate(input);
        assertEquals(compareConcat, result);
    }
}
