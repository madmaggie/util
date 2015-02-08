package com.utils.file;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rox on 07.02.2015.
 */
public class JsonUtil {

    /* should be called like this:
     *  jsonToMap(FileUtils.readFileToString(new File("src/test/resources/cd/fileOtherName.txt") */
    public static Map<String, Object> jsonToMap(String choice) {
        Map<String, Object> mapFromFile = new HashMap<>();

        if (choice.equals("file1")) {
            mapFromFile.put("FIRSTFILEFIRSTCOLUMN", "value1");
            mapFromFile.put("firstFileSecondColumn", "value2");
            mapFromFile.put("firstFileThirdColumn", "value3");
        }
        if (choice.equals("file2")) {
            mapFromFile.put("secondFileFirstColumn", "value1");
            mapFromFile.put("secondFileSecondColumn", "value2");
            mapFromFile.put("secondFileThirdColumn", "value3");
            mapFromFile.put("secondFileFourthColumn", "value3");
        }
        return mapFromFile;
    }
}
