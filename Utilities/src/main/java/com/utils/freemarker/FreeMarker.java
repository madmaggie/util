package com.utils.freemarker;

import freemarker.template.*;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

/**
 * Created by Rox on 15.11.2014.
 */
public class FreeMarker {

    private static Configuration cfg;

    private static String templateLocation = "src\\main\\resources\\";

    private static String templateFileName = "simpleTemplate.ftl";

    public static void initConfig() {
        try {
            // Initialize configuration;
            cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File(templateLocation));
            cfg.setTemplateUpdateDelay(0);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

            //Use beans wrapper
            cfg.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
            cfg.setDefaultEncoding("ISO-8859-1");

            //charset of the output
            cfg.setOutputEncoding("UTF-8");

            //default locale
            cfg.setLocale(Locale.US);


        } catch (Exception e) {
            //handle the exception
        }
    }

    public static String processTemplate(TemplateClass dataObject) {
        String strResponse = null;
        try {
            Template template = cfg.getTemplate(templateFileName);
            Writer out = new StringWriter();
            template.process(dataObject, out);
            strResponse  = out.toString();
        } catch (Exception e) {

        }
        return strResponse;
    }
}
