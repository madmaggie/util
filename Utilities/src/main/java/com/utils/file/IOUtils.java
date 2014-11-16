package com.utils.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import org.apache.commons.io.FileUtils;

/**
 * Created by Rox on 16.11.2014.
 */
public class IOUtils {

    public static final String LINE_SEPARATOR = "\r\n|\n|\r";

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public boolean writeFile(final String file, final String data) { boolean writeWasOk = false; try {
        org.apache.commons.io.FileUtils.writeStringToFile(new File(file), data); writeWasOk = true;
    } catch (IOException e) {
        logger.error("Could not write to the output file: " + file, e); } return writeWasOk;
    }

    public boolean deleteFile(final String file) {
        boolean deleteWasOk = false;
        try {
            Files.delete(FileSystems.getDefault().getPath(file));
            deleteWasOk = true;
        } catch (IOException e) {
            logger.error("Could not delete the output file: " + file, e);
        }
        return deleteWasOk;
    }

    public boolean initRootFolder(final String rootFolder) {

        boolean result = true;
        File root = new File(rootFolder);

        if (!root.exists()) {
            result = new File(rootFolder).mkdirs();
        }
        return result;
    }

    public int getNumberOfLines(final String str) throws IOException {
        return str.split("\r\n|\r|\n").length;
    }
}
